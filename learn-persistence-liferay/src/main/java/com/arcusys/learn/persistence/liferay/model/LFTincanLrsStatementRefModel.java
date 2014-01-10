package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
* The base model interface for the LFTincanLrsStatementRef service. Represents a row in the &quot;Learn_LFTincanLrsStatementRef&quot; database table, with each column mapped to a property of this class.
*
* <p>
    * This interface and its corresponding implementation {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementRefModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementRefImpl}.
    * </p>
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsStatementRef
* @see com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementRefImpl
* @see com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementRefModelImpl
* @generated
*/
public interface LFTincanLrsStatementRefModel extends BaseModel<LFTincanLrsStatementRef> {
    /*
    * NOTE FOR DEVELOPERS:
    *
    * Never modify or reference this interface directly. All methods that expect a l f tincan lrs statement ref model instance should use the {@link LFTincanLrsStatementRef} interface instead.
    */

    /**
    * Returns the primary key of this l f tincan lrs statement ref.
    *
    * @return the primary key of this l f tincan lrs statement ref
    */
    public long getPrimaryKey();

    /**
    * Sets the primary key of this l f tincan lrs statement ref.
    *
    * @param primaryKey the primary key of this l f tincan lrs statement ref
    */
    public void setPrimaryKey(long primaryKey);

    /**
    * Returns the ID of this l f tincan lrs statement ref.
    *
    * @return the ID of this l f tincan lrs statement ref
    */
    public long getId();

    /**
        * Sets the ID of this l f tincan lrs statement ref.
    *
    * @param id the ID of this l f tincan lrs statement ref
    */
    public void setId(long id);

    /**
    * Returns the uuid of this l f tincan lrs statement ref.
    *
    * @return the uuid of this l f tincan lrs statement ref
    */
    @AutoEscape
    public String getUuid();

    /**
        * Sets the uuid of this l f tincan lrs statement ref.
    *
    * @param uuid the uuid of this l f tincan lrs statement ref
    */
    public void setUuid(String uuid);

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

    public int compareTo(LFTincanLrsStatementRef lfTincanLrsStatementRef);

    public int hashCode();

    public CacheModel<LFTincanLrsStatementRef> toCacheModel();

    public LFTincanLrsStatementRef toEscapedModel();

    public String toString();

    public String toXmlString();
}
