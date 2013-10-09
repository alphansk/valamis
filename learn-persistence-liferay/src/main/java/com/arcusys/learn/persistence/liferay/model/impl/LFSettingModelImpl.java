package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSetting;
import com.arcusys.learn.persistence.liferay.model.LFSettingModel;

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
* The base model implementation for the LFSetting service. Represents a row in the &quot;Learn_LFSetting&quot; database table, with each column mapped to a property of this class.
*
* <p>
    * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFSettingModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFSettingImpl}.
    * </p>
*
* @author Brian Wing Shun Chan
* @see LFSettingImpl
* @see com.arcusys.learn.persistence.liferay.model.LFSetting
* @see com.arcusys.learn.persistence.liferay.model.LFSettingModel
* @generated
*/
public class LFSettingModelImpl extends BaseModelImpl<LFSetting>
    implements LFSettingModel {
    /*
    * NOTE FOR DEVELOPERS:
    *
    * Never modify or reference this class directly. All methods that expect a l f setting model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFSetting} interface instead.
    */
    public static final String TABLE_NAME = "Learn_LFSetting";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "key_", Types.VARCHAR },
            { "value", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFSetting (id_ LONG not null primary key,key_ VARCHAR(75) null,value VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFSetting";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFSetting"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFSetting"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFSetting"),
            true);
    public static long KEY_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFSetting"));
    private static ClassLoader _classLoader = LFSetting.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            LFSetting.class
        };
    private long _id;
    private String _key;
    private String _originalKey;
    private String _value;
    private long _columnBitmask;
    private LFSetting _escapedModelProxy;

    public LFSettingModelImpl() {
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
        return LFSetting.class;
    }

    public String getModelClassName() {
        return LFSetting.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("key", getKey());
        attributes.put("value", getValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String value = (String) attributes.get("value");

        if (value != null) {
            setValue(value);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getKey() {
        if (_key == null) {
            return StringPool.BLANK;
        } else {
            return _key;
        }
    }

    public void setKey(String key) {
        _columnBitmask |= KEY_COLUMN_BITMASK;

        if (_originalKey == null) {
            _originalKey = _key;
        }

        _key = key;
    }

    public String getOriginalKey() {
        return GetterUtil.getString(_originalKey);
    }

    public String getValue() {
        if (_value == null) {
            return StringPool.BLANK;
        } else {
            return _value;
        }
    }

    public void setValue(String value) {
        _value = value;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFSetting.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFSetting toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (LFSetting) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        LFSettingImpl lfSettingImpl = new LFSettingImpl();

        lfSettingImpl.setId(getId());
        lfSettingImpl.setKey(getKey());
        lfSettingImpl.setValue(getValue());

        lfSettingImpl.resetOriginalValues();

        return lfSettingImpl;
    }

    public int compareTo(LFSetting lfSetting) {
        long primaryKey = lfSetting.getPrimaryKey();

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

        LFSetting lfSetting = null;

        try {
            lfSetting = (LFSetting) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfSetting.getPrimaryKey();

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
        LFSettingModelImpl lfSettingModelImpl = this;

        lfSettingModelImpl._originalKey = lfSettingModelImpl._key;

        lfSettingModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFSetting> toCacheModel() {
        LFSettingCacheModel lfSettingCacheModel = new LFSettingCacheModel();

        lfSettingCacheModel.id = getId();

        lfSettingCacheModel.key = getKey();

        String key = lfSettingCacheModel.key;

        if ((key != null) && (key.length() == 0)) {
            lfSettingCacheModel.key = null;
        }

        lfSettingCacheModel.value = getValue();

        String value = lfSettingCacheModel.value;

        if ((value != null) && (value.length() == 0)) {
            lfSettingCacheModel.value = null;
        }

        return lfSettingCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", key=");
        sb.append(getKey());
        sb.append(", value=");
        sb.append(getValue());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFSetting");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>key</column-name><column-value><![CDATA[");
        sb.append(getKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>value</column-name><column-value><![CDATA[");
        sb.append(getValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}