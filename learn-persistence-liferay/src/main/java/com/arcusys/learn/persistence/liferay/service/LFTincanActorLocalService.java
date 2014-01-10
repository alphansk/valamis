package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the l f tincan actor local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActorLocalServiceUtil
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanActorLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFTincanActorLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface LFTincanActorLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanActorLocalServiceUtil} to access the l f tincan actor local service. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFTincanActorLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the l f tincan actor to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActor the l f tincan actor
    * @return the l f tincan actor that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor addLFTincanActor(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new l f tincan actor with the primary key. Does not add the l f tincan actor to the database.
    *
    * @param id the primary key for the new l f tincan actor
    * @return the new l f tincan actor
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor createLFTincanActor(
        long id);

    /**
    * Deletes the l f tincan actor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor that was removed
    * @throws PortalException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor deleteLFTincanActor(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the l f tincan actor from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActor the l f tincan actor
    * @return the l f tincan actor that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor deleteLFTincanActor(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchLFTincanActor(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan actor with the primary key.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor
    * @throws PortalException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor getLFTincanActor(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan actors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @return the range of l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> getLFTincanActors(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan actors.
    *
    * @return the number of l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getLFTincanActorsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the l f tincan actor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActor the l f tincan actor
    * @return the l f tincan actor that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor updateLFTincanActor(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the l f tincan actor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActor the l f tincan actor
    * @param merge whether to merge the l f tincan actor with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan actor that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor updateLFTincanActor(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanActor createLFTincanActor()
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByMemberOf(
        java.lang.String memberOf)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanActor findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findAgent(
        java.lang.String name, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid)
        throws com.liferay.portal.kernel.exception.SystemException;
}
