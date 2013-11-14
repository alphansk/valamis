package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFUser;
import com.arcusys.learn.persistence.liferay.model.LFUserModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
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
* The base model implementation for the LFUser service. Represents a row in the &quot;Learn_LFUser&quot; database table, with each column mapped to a property of this class.
*
* <p>
    * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFUserModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFUserImpl}.
    * </p>
*
* @author Brian Wing Shun Chan
* @see LFUserImpl
* @see com.arcusys.learn.persistence.liferay.model.LFUser
* @see com.arcusys.learn.persistence.liferay.model.LFUserModel
* @generated
*/
public class LFUserModelImpl extends BaseModelImpl<LFUser>
    implements LFUserModel {
    /*
    * NOTE FOR DEVELOPERS:
    *
    * Never modify or reference this class directly. All methods that expect a l f user model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFUser} interface instead.
    */
    public static final String TABLE_NAME = "Learn_LFUser";
    public static final Object[][] TABLE_COLUMNS = {
            { "lfid", Types.BIGINT },
            { "id_", Types.INTEGER },
            { "name", Types.CLOB },
            { "preferredAudioLevel", Types.DOUBLE },
            { "preferredLanguage", Types.CLOB },
            { "preferredDeliverySpeed", Types.DOUBLE },
            { "preferredAudioCaptioning", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFUser (lfid LONG not null primary key,id_ INTEGER null,name TEXT null,preferredAudioLevel DOUBLE null,preferredLanguage TEXT null,preferredDeliverySpeed DOUBLE null,preferredAudioCaptioning INTEGER null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFUser";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFUser"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFUser"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFUser"),
            true);
    public static long ID_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFUser"));
    private static ClassLoader _classLoader = LFUser.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            LFUser.class
        };
    private long _lfid;
    private Integer _id;
    private Integer _originalId;
    private boolean _setOriginalId;
    private String _name;
    private Double _preferredAudioLevel;
    private String _preferredLanguage;
    private Double _preferredDeliverySpeed;
    private Integer _preferredAudioCaptioning;
    private long _columnBitmask;
    private LFUser _escapedModelProxy;

    public LFUserModelImpl() {
    }

    public long getPrimaryKey() {
        return _lfid;
    }

    public void setPrimaryKey(long primaryKey) {
        setLfid(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_lfid);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return LFUser.class;
    }

    public String getModelClassName() {
        return LFUser.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("lfid", getLfid());
        attributes.put("id", getId());
        attributes.put("name", getName());
        attributes.put("preferredAudioLevel", getPreferredAudioLevel());
        attributes.put("preferredLanguage", getPreferredLanguage());
        attributes.put("preferredDeliverySpeed", getPreferredDeliverySpeed());
        attributes.put("preferredAudioCaptioning", getPreferredAudioCaptioning());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long lfid = (Long) attributes.get("lfid");

        if (lfid != null) {
            setLfid(lfid);
        }

        Integer id = (Integer) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Double preferredAudioLevel = (Double) attributes.get(
                "preferredAudioLevel");

        if (preferredAudioLevel != null) {
            setPreferredAudioLevel(preferredAudioLevel);
        }

        String preferredLanguage = (String) attributes.get("preferredLanguage");

        if (preferredLanguage != null) {
            setPreferredLanguage(preferredLanguage);
        }

        Double preferredDeliverySpeed = (Double) attributes.get(
                "preferredDeliverySpeed");

        if (preferredDeliverySpeed != null) {
            setPreferredDeliverySpeed(preferredDeliverySpeed);
        }

        Integer preferredAudioCaptioning = (Integer) attributes.get(
                "preferredAudioCaptioning");

        if (preferredAudioCaptioning != null) {
            setPreferredAudioCaptioning(preferredAudioCaptioning);
        }
    }

    public long getLfid() {
        return _lfid;
    }

    public void setLfid(long lfid) {
        _lfid = lfid;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _columnBitmask |= ID_COLUMN_BITMASK;

        if (!_setOriginalId) {
            _setOriginalId = true;

            _originalId = _id;
        }

        _id = id;
    }

    public Integer getOriginalId() {
        return _originalId;
    }

    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    public void setName(String name) {
        _name = name;
    }

    public Double getPreferredAudioLevel() {
        return _preferredAudioLevel;
    }

    public void setPreferredAudioLevel(Double preferredAudioLevel) {
        _preferredAudioLevel = preferredAudioLevel;
    }

    public String getPreferredLanguage() {
        if (_preferredLanguage == null) {
            return StringPool.BLANK;
        } else {
            return _preferredLanguage;
        }
    }

    public void setPreferredLanguage(String preferredLanguage) {
        _preferredLanguage = preferredLanguage;
    }

    public Double getPreferredDeliverySpeed() {
        return _preferredDeliverySpeed;
    }

    public void setPreferredDeliverySpeed(Double preferredDeliverySpeed) {
        _preferredDeliverySpeed = preferredDeliverySpeed;
    }

    public Integer getPreferredAudioCaptioning() {
        return _preferredAudioCaptioning;
    }

    public void setPreferredAudioCaptioning(Integer preferredAudioCaptioning) {
        _preferredAudioCaptioning = preferredAudioCaptioning;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFUser.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFUser toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (LFUser) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        LFUserImpl lfUserImpl = new LFUserImpl();

        lfUserImpl.setLfid(getLfid());
        lfUserImpl.setId(getId());
        lfUserImpl.setName(getName());
        lfUserImpl.setPreferredAudioLevel(getPreferredAudioLevel());
        lfUserImpl.setPreferredLanguage(getPreferredLanguage());
        lfUserImpl.setPreferredDeliverySpeed(getPreferredDeliverySpeed());
        lfUserImpl.setPreferredAudioCaptioning(getPreferredAudioCaptioning());

        lfUserImpl.resetOriginalValues();

        return lfUserImpl;
    }

    public int compareTo(LFUser lfUser) {
        long primaryKey = lfUser.getPrimaryKey();

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

        LFUser lfUser = null;

        try {
            lfUser = (LFUser) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfUser.getPrimaryKey();

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
        LFUserModelImpl lfUserModelImpl = this;

        lfUserModelImpl._originalId = lfUserModelImpl._id;

        lfUserModelImpl._setOriginalId = false;

        lfUserModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFUser> toCacheModel() {
        LFUserCacheModel lfUserCacheModel = new LFUserCacheModel();

        lfUserCacheModel.lfid = getLfid();

        lfUserCacheModel.id = getId();

        lfUserCacheModel.name = getName();

        String name = lfUserCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            lfUserCacheModel.name = null;
        }

        lfUserCacheModel.preferredAudioLevel = getPreferredAudioLevel();

        lfUserCacheModel.preferredLanguage = getPreferredLanguage();

        String preferredLanguage = lfUserCacheModel.preferredLanguage;

        if ((preferredLanguage != null) && (preferredLanguage.length() == 0)) {
            lfUserCacheModel.preferredLanguage = null;
        }

        lfUserCacheModel.preferredDeliverySpeed = getPreferredDeliverySpeed();

        lfUserCacheModel.preferredAudioCaptioning = getPreferredAudioCaptioning();

        return lfUserCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{lfid=");
        sb.append(getLfid());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", preferredAudioLevel=");
        sb.append(getPreferredAudioLevel());
        sb.append(", preferredLanguage=");
        sb.append(getPreferredLanguage());
        sb.append(", preferredDeliverySpeed=");
        sb.append(getPreferredDeliverySpeed());
        sb.append(", preferredAudioCaptioning=");
        sb.append(getPreferredAudioCaptioning());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFUser");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>lfid</column-name><column-value><![CDATA[");
        sb.append(getLfid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>preferredAudioLevel</column-name><column-value><![CDATA[");
        sb.append(getPreferredAudioLevel());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>preferredLanguage</column-name><column-value><![CDATA[");
        sb.append(getPreferredLanguage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>preferredDeliverySpeed</column-name><column-value><![CDATA[");
        sb.append(getPreferredDeliverySpeed());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>preferredAudioCaptioning</column-name><column-value><![CDATA[");
        sb.append(getPreferredAudioCaptioning());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
