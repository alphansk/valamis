package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSequencingTracking;
import com.arcusys.learn.persistence.liferay.model.LFSequencingTrackingModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
* The base model implementation for the LFSequencingTracking service. Represents a row in the &quot;Learn_LFSequencingTracking&quot; database table, with each column mapped to a property of this class.
*
* <p>
    * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFSequencingTrackingModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFSequencingTrackingImpl}.
    * </p>
*
* @author Brian Wing Shun Chan
* @see LFSequencingTrackingImpl
* @see com.arcusys.learn.persistence.liferay.model.LFSequencingTracking
* @see com.arcusys.learn.persistence.liferay.model.LFSequencingTrackingModel
* @generated
*/
public class LFSequencingTrackingModelImpl extends BaseModelImpl<LFSequencingTracking>
    implements LFSequencingTrackingModel {
    /*
    * NOTE FOR DEVELOPERS:
    *
    * Never modify or reference this class directly. All methods that expect a l f sequencing tracking model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFSequencingTracking} interface instead.
    */
    public static final String TABLE_NAME = "Learn_LFSequencingTracking";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "sequencingID", Types.INTEGER },
            { "completionSetByContent", Types.BOOLEAN },
            { "objectiveSetByContent", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFSequencingTracking (id_ LONG not null primary key,sequencingID INTEGER null,completionSetByContent BOOLEAN null,objectiveSetByContent BOOLEAN null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFSequencingTracking";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFSequencingTracking"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFSequencingTracking"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFSequencingTracking"),
            true);
    public static long SEQUENCINGID_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFSequencingTracking"));
    private static ClassLoader _classLoader = LFSequencingTracking.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            LFSequencingTracking.class
        };
    private long _id;
    private Integer _sequencingID;
    private Integer _originalSequencingID;
    private boolean _setOriginalSequencingID;
    private boolean _completionSetByContent;
    private boolean _objectiveSetByContent;
    private long _columnBitmask;
    private LFSequencingTracking _escapedModelProxy;

    public LFSequencingTrackingModelImpl() {
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return LFSequencingTracking.class;
    }

    public String getModelClassName() {
        return LFSequencingTracking.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("completionSetByContent", getCompletionSetByContent());
        attributes.put("objectiveSetByContent", getObjectiveSetByContent());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        Boolean completionSetByContent = (Boolean) attributes.get(
                "completionSetByContent");

        if (completionSetByContent != null) {
            setCompletionSetByContent(completionSetByContent);
        }

        Boolean objectiveSetByContent = (Boolean) attributes.get(
                "objectiveSetByContent");

        if (objectiveSetByContent != null) {
            setObjectiveSetByContent(objectiveSetByContent);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getSequencingID() {
        return _sequencingID;
    }

    public void setSequencingID(Integer sequencingID) {
        _columnBitmask |= SEQUENCINGID_COLUMN_BITMASK;

        if (!_setOriginalSequencingID) {
            _setOriginalSequencingID = true;

            _originalSequencingID = _sequencingID;
        }

        _sequencingID = sequencingID;
    }

    public Integer getOriginalSequencingID() {
        return _originalSequencingID;
    }

    public boolean getCompletionSetByContent() {
        return _completionSetByContent;
    }

    public boolean isCompletionSetByContent() {
        return _completionSetByContent;
    }

    public void setCompletionSetByContent(boolean completionSetByContent) {
        _completionSetByContent = completionSetByContent;
    }

    public boolean getObjectiveSetByContent() {
        return _objectiveSetByContent;
    }

    public boolean isObjectiveSetByContent() {
        return _objectiveSetByContent;
    }

    public void setObjectiveSetByContent(boolean objectiveSetByContent) {
        _objectiveSetByContent = objectiveSetByContent;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFSequencingTracking.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFSequencingTracking toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (LFSequencingTracking) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        LFSequencingTrackingImpl lfSequencingTrackingImpl = new LFSequencingTrackingImpl();

        lfSequencingTrackingImpl.setId(getId());
        lfSequencingTrackingImpl.setSequencingID(getSequencingID());
        lfSequencingTrackingImpl.setCompletionSetByContent(getCompletionSetByContent());
        lfSequencingTrackingImpl.setObjectiveSetByContent(getObjectiveSetByContent());

        lfSequencingTrackingImpl.resetOriginalValues();

        return lfSequencingTrackingImpl;
    }

    public int compareTo(LFSequencingTracking lfSequencingTracking) {
        long primaryKey = lfSequencingTracking.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFSequencingTracking lfSequencingTracking = null;

        try {
            lfSequencingTracking = (LFSequencingTracking) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfSequencingTracking.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        LFSequencingTrackingModelImpl lfSequencingTrackingModelImpl = this;

        lfSequencingTrackingModelImpl._originalSequencingID = lfSequencingTrackingModelImpl._sequencingID;

        lfSequencingTrackingModelImpl._setOriginalSequencingID = false;

        lfSequencingTrackingModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFSequencingTracking> toCacheModel() {
        LFSequencingTrackingCacheModel lfSequencingTrackingCacheModel = new LFSequencingTrackingCacheModel();

        lfSequencingTrackingCacheModel.id = getId();

        lfSequencingTrackingCacheModel.sequencingID = getSequencingID();

        lfSequencingTrackingCacheModel.completionSetByContent = getCompletionSetByContent();

        lfSequencingTrackingCacheModel.objectiveSetByContent = getObjectiveSetByContent();

        return lfSequencingTrackingCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", sequencingID=");
        sb.append(getSequencingID());
        sb.append(", completionSetByContent=");
        sb.append(getCompletionSetByContent());
        sb.append(", objectiveSetByContent=");
        sb.append(getObjectiveSetByContent());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFSequencingTracking");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sequencingID</column-name><column-value><![CDATA[");
        sb.append(getSequencingID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>completionSetByContent</column-name><column-value><![CDATA[");
        sb.append(getCompletionSetByContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectiveSetByContent</column-name><column-value><![CDATA[");
        sb.append(getObjectiveSetByContent());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
