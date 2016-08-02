package com.arcusys.valamis.social.service

import com.arcusys.learn.liferay.LiferayClasses.LSocialActivity
import com.arcusys.learn.liferay.model.Activity
import com.arcusys.learn.liferay.services.{ServiceContextHelper, SocialActivityLocalServiceHelper, UserLocalServiceHelper}
import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper._
import com.arcusys.valamis.certificate.model.{Certificate, CertificateActivityType, CertificateStateType}
import com.arcusys.valamis.gradebook.model.{CourseActivityType, CourseGrade}
import com.arcusys.valamis.lesson.model._
import com.arcusys.valamis.lesson.service.LessonService
import com.arcusys.valamis.liferay.SocialActivityHelper
import com.arcusys.valamis.model.SkipTake
import com.arcusys.valamis.social.model.UserStatus
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import org.joda.time.DateTime

class ActivityServiceImpl(implicit val bindingModule: BindingModule)
  extends ActivityService
  with Injectable {
  val supportedActivities = Set(
    classOf[Lesson].getName,
    classOf[Certificate].getName,
    CertificateStateType.getClass.getName,
    CertificateActivityType.getClass.getName,
    classOf[CourseGrade].getName,
    CourseActivityType.getClass.getName,
    classOf[UserStatus].getName)

  lazy val lessonService = inject[LessonService]
  lazy val userSocialActivityHelper = new SocialActivityHelper[UserStatus]
  lazy val lessonActivityHelper = new SocialActivityHelper[Lesson]

  def create(companyId: Long, userId: Long, content: String): Activity = {
    userSocialActivityHelper.addWithSet(
      companyId,
      userId,
      extraData = Some(content),
      createDate = DateTime.now
    )
  }

  def share(companyId: Long, userId: Long, lessonId: Long, comment: Option[String]): Option[Activity] = {
    lessonService.getLesson(lessonId) map { lesson =>
      lessonActivityHelper.addWithSet(
        companyId,
        userId,
        `type` = Some(PackageActivityType.Shared.id),
        classPK = Some(lesson.id),
        extraData = comment,
        createDate = DateTime.now
      )
    }
  }

  override def getBy(companyId: Long, userId: Option[Long], skipTake: Option[SkipTake], showAll: Boolean, lActivitiesToBeShown: Option[Set[String]]): Seq[Activity] = {
    implicit val dateTimeOrdering: Ordering[DateTime] = Ordering.fromLessThan(_ isBefore _)
    val curUser = UserLocalServiceHelper().getUser(ServiceContextHelper.getServiceContext.getUserId)

    //todo add activities that should be hidden and add this condition to filter
    val hiddenActivities = Set(CertificateActivityType.getClass.getName)

    val filter: LSocialActivity => Boolean = { activity =>
      val className = activity.getClassName
      (supportedActivities.contains(className) || className.contains("com.liferay")) &&
      (!className.contains("com.liferay") || lActivitiesToBeShown.fold(true)(_.contains(className))) &&
      userId.fold(true)(_ == activity.getUserId) &&
      toOption(activity.getGroupId).fold(true)(UserLocalServiceHelper().getGroupUsers(_).contains(curUser)) &&
      (showAll || !hiddenActivities.contains(className))
    }

    val result = SocialActivityLocalServiceHelper
      .getBy(companyId = companyId)(filter)
      .sorted(Ordering.by((_: Activity).createDate).reverse)

    skipTake match {
      case None => result.take(6)
      case Some(SkipTake(skip, take)) =>
        result.slice(skip, skip + take)
    }
  }

  def getById(activityId: Long): Activity = {
    SocialActivityLocalServiceHelper.getById(activityId)
  }

  def delete(activityId: Long): Unit = {
    SocialActivityLocalServiceHelper.deleteActivity(activityId)
  }
}
