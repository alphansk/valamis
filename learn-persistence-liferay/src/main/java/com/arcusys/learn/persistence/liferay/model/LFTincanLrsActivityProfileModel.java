package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
* The base model interface for the LFTincanLrsActivityProfile service. Represents a row in the &quot;Learn_LFTincanLrsActivityProfile&quot; database table, with each column mapped to a property of this class.
*
* <p>
    * This interface and its corresponding implementation {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileImpl}.
    * </p>
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsActivityProfile
* @see com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileImpl
* @see com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileModelImpl
* @generated
*/
public interface LFTincanLrsActivityProfileModel extends BaseModel<LFTincanLrsActivityProfile> {
    /*
    * NOTE FOR DEVELOPERS:
    *
    * Never modify or reference this interface directly. All methods that expect a l f tincan lrs activity profile model instance should use the {@link LFTincanLrsActivityProfile} interface instead.
    */

    /**
    * Returns the primary key of this l f tincan lrs activity profile.
    *
    * @return the primary key of this l f tincan lrs activity profile
    */
    public long getPrimaryKey();

    /**
    * Sets the primary key of this l f tincan lrs activity profile.
    *
    * @param primaryKey the primary key of this l f tincan lrs activity profile
    */
    public void setPrimaryKey(long primaryKey);

    /**
    * Returns the ID of this l f tincan lrs activity profile.
    *
    * @return the ID of this l f tincan lrs activity profile
    */
    public long getId();

    /**
        * Sets the ID of this l f tincan lrs activity profile.
    *
    * @param id the ID of this l f tincan lrs activity profile
    */
    public void setId(long id);

    /**
    * Returns the document ID of this l f tincan lrs activity profile.
    *
    * @return the document ID of this l f tincan lrs activity profile
    */
    public Integer getDocumentId();

    /**
        * Sets the document ID of this l f tincan lrs activity profile.
    *
    * @param documentId the document ID of this l f tincan lrs activity profile
    */
    public void setDocumentId(Integer documentId);

    /**
    * Returns the activity ID of this l f tincan lrs activity profile.
    *
    * @return the activity ID of this l f tincan lrs activity profile
    */
    @AutoEscape
    public String getActivityId();

    /**
        * Sets the activity ID of this l f tincan lrs activity profile.
    *
    * @param activityId the activity ID of this l f tincan lrs activity profile
    */
    public void setActivityId(String activityId);

    /**
    * Returns the profile ID of this l f tincan lrs activity profile.
    *
    * @return the profile ID of this l f tincan lrs activity profile
    */
    @AutoEscape
    public String getProfileId();

    /**
        * Sets the profile ID of this l f tincan lrs activity profile.
    *
    * @param profileId the profile ID of this l f tincan lrs activity profile
    */
    public void setProfileId(String profileId);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(LFTincanLrsActivityProfile lfTincanLrsActivityProfile);

    public int hashCode();

    public CacheModel<LFTincanLrsActivityProfile> toCacheModel();

    public LFTincanLrsActivityProfile toEscapedModel();

    public String toString();

    public String toXmlString();
}
