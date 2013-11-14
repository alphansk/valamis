package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateTreeModel;

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
* The base model implementation for the LFActivityStateTree service. Represents a row in the &quot;Learn_LFActivityStateTree&quot; database table, with each column mapped to a property of this class.
*
* <p>
    * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFActivityStateTreeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFActivityStateTreeImpl}.
    * </p>
*
* @author Brian Wing Shun Chan
* @see LFActivityStateTreeImpl
* @see com.arcusys.learn.persistence.liferay.model.LFActivityStateTree
* @see com.arcusys.learn.persistence.liferay.model.LFActivityStateTreeModel
* @generated
*/
public class LFActivityStateTreeModelImpl extends BaseModelImpl<LFActivityStateTree>
    implements LFActivityStateTreeModel {
    /*
    * NOTE FOR DEVELOPERS:
    *
    * Never modify or reference this class directly. All methods that expect a l f activity state tree model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFActivityStateTree} interface instead.
    */
    public static final String TABLE_NAME = "Learn_LFActivityStateTree";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "currentActivityID", Types.CLOB },
            { "suspendedActivityID", Types.CLOB },
            { "attemptID", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFActivityStateTree (id_ LONG not null primary key,currentActivityID TEXT null,suspendedActivityID TEXT null,attemptID INTEGER null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFActivityStateTree";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFActivityStateTree"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFActivityStateTree"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFActivityStateTree"),
            true);
    public static long ATTEMPTID_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFActivityStateTree"));
    private static ClassLoader _classLoader = LFActivityStateTree.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            LFActivityStateTree.class
        };
    private long _id;
    private String _currentActivityID;
    private String _suspendedActivityID;
    private Integer _attemptID;
    private Integer _originalAttemptID;
    private boolean _setOriginalAttemptID;
    private long _columnBitmask;
    private LFActivityStateTree _escapedModelProxy;

    public LFActivityStateTreeModelImpl() {
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
        return LFActivityStateTree.class;
    }

    public String getModelClassName() {
        return LFActivityStateTree.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("currentActivityID", getCurrentActivityID());
        attributes.put("suspendedActivityID", getSuspendedActivityID());
        attributes.put("attemptID", getAttemptID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String currentActivityID = (String) attributes.get("currentActivityID");

        if (currentActivityID != null) {
            setCurrentActivityID(currentActivityID);
        }

        String suspendedActivityID = (String) attributes.get(
                "suspendedActivityID");

        if (suspendedActivityID != null) {
            setSuspendedActivityID(suspendedActivityID);
        }

        Integer attemptID = (Integer) attributes.get("attemptID");

        if (attemptID != null) {
            setAttemptID(attemptID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getCurrentActivityID() {
        return _currentActivityID;
    }

    public void setCurrentActivityID(String currentActivityID) {
        _currentActivityID = currentActivityID;
    }

    public String getSuspendedActivityID() {
        return _suspendedActivityID;
    }

    public void setSuspendedActivityID(String suspendedActivityID) {
        _suspendedActivityID = suspendedActivityID;
    }

    public Integer getAttemptID() {
        return _attemptID;
    }

    public void setAttemptID(Integer attemptID) {
        _columnBitmask |= ATTEMPTID_COLUMN_BITMASK;

        if (!_setOriginalAttemptID) {
            _setOriginalAttemptID = true;

            _originalAttemptID = _attemptID;
        }

        _attemptID = attemptID;
    }

    public Integer getOriginalAttemptID() {
        return _originalAttemptID;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFActivityStateTree.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFActivityStateTree toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (LFActivityStateTree) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        LFActivityStateTreeImpl lfActivityStateTreeImpl = new LFActivityStateTreeImpl();

        lfActivityStateTreeImpl.setId(getId());
        lfActivityStateTreeImpl.setCurrentActivityID(getCurrentActivityID());
        lfActivityStateTreeImpl.setSuspendedActivityID(getSuspendedActivityID());
        lfActivityStateTreeImpl.setAttemptID(getAttemptID());

        lfActivityStateTreeImpl.resetOriginalValues();

        return lfActivityStateTreeImpl;
    }

    public int compareTo(LFActivityStateTree lfActivityStateTree) {
        long primaryKey = lfActivityStateTree.getPrimaryKey();

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

        LFActivityStateTree lfActivityStateTree = null;

        try {
            lfActivityStateTree = (LFActivityStateTree) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfActivityStateTree.getPrimaryKey();

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
        LFActivityStateTreeModelImpl lfActivityStateTreeModelImpl = this;

        lfActivityStateTreeModelImpl._originalAttemptID = lfActivityStateTreeModelImpl._attemptID;

        lfActivityStateTreeModelImpl._setOriginalAttemptID = false;

        lfActivityStateTreeModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFActivityStateTree> toCacheModel() {
        LFActivityStateTreeCacheModel lfActivityStateTreeCacheModel = new LFActivityStateTreeCacheModel();

        lfActivityStateTreeCacheModel.id = getId();

        lfActivityStateTreeCacheModel.currentActivityID = getCurrentActivityID();

        String currentActivityID = lfActivityStateTreeCacheModel.currentActivityID;

        if ((currentActivityID != null) && (currentActivityID.length() == 0)) {
            lfActivityStateTreeCacheModel.currentActivityID = null;
        }

        lfActivityStateTreeCacheModel.suspendedActivityID = getSuspendedActivityID();

        String suspendedActivityID = lfActivityStateTreeCacheModel.suspendedActivityID;

        if ((suspendedActivityID != null) &&
                (suspendedActivityID.length() == 0)) {
            lfActivityStateTreeCacheModel.suspendedActivityID = null;
        }

        lfActivityStateTreeCacheModel.attemptID = getAttemptID();

        return lfActivityStateTreeCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", currentActivityID=");
        sb.append(getCurrentActivityID());
        sb.append(", suspendedActivityID=");
        sb.append(getSuspendedActivityID());
        sb.append(", attemptID=");
        sb.append(getAttemptID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFActivityStateTree");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>currentActivityID</column-name><column-value><![CDATA[");
        sb.append(getCurrentActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>suspendedActivityID</column-name><column-value><![CDATA[");
        sb.append(getSuspendedActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptID</column-name><column-value><![CDATA[");
        sb.append(getAttemptID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
