package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory;
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategoryModel;

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
* The base model implementation for the LFQuizQuestionCategory service. Represents a row in the &quot;Learn_LFQuizQuestionCategory&quot; database table, with each column mapped to a property of this class.
*
* <p>
    * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFQuizQuestionCategoryImpl}.
    * </p>
*
* @author Brian Wing Shun Chan
* @see LFQuizQuestionCategoryImpl
* @see com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory
* @see com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategoryModel
* @generated
*/
public class LFQuizQuestionCategoryModelImpl extends BaseModelImpl<LFQuizQuestionCategory>
    implements LFQuizQuestionCategoryModel {
    /*
    * NOTE FOR DEVELOPERS:
    *
    * Never modify or reference this class directly. All methods that expect a l f quiz question category model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory} interface instead.
    */
    public static final String TABLE_NAME = "Learn_LFQuizQuestionCategory";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "title", Types.CLOB },
            { "description", Types.CLOB },
            { "quizId", Types.INTEGER },
            { "parentId", Types.INTEGER },
            { "arrangementIndex", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFQuizQuestionCategory (id_ LONG not null primary key,title TEXT null,description TEXT null,quizId INTEGER null,parentId INTEGER null,arrangementIndex INTEGER null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFQuizQuestionCategory";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory"),
            true);
    public static long PARENTID_COLUMN_BITMASK = 1L;
    public static long QUIZID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory"));
    private static ClassLoader _classLoader = LFQuizQuestionCategory.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            LFQuizQuestionCategory.class
        };
    private long _id;
    private String _title;
    private String _description;
    private Integer _quizId;
    private Integer _originalQuizId;
    private boolean _setOriginalQuizId;
    private Integer _parentId;
    private Integer _originalParentId;
    private boolean _setOriginalParentId;
    private Integer _arrangementIndex;
    private long _columnBitmask;
    private LFQuizQuestionCategory _escapedModelProxy;

    public LFQuizQuestionCategoryModelImpl() {
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
        return LFQuizQuestionCategory.class;
    }

    public String getModelClassName() {
        return LFQuizQuestionCategory.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("quizId", getQuizId());
        attributes.put("parentId", getParentId());
        attributes.put("arrangementIndex", getArrangementIndex());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Integer quizId = (Integer) attributes.get("quizId");

        if (quizId != null) {
            setQuizId(quizId);
        }

        Integer parentId = (Integer) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getTitle() {
        if (_title == null) {
            return StringPool.BLANK;
        } else {
            return _title;
        }
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Integer getQuizId() {
        return _quizId;
    }

    public void setQuizId(Integer quizId) {
        _columnBitmask |= QUIZID_COLUMN_BITMASK;

        if (!_setOriginalQuizId) {
            _setOriginalQuizId = true;

            _originalQuizId = _quizId;
        }

        _quizId = quizId;
    }

    public Integer getOriginalQuizId() {
        return _originalQuizId;
    }

    public Integer getParentId() {
        return _parentId;
    }

    public void setParentId(Integer parentId) {
        _columnBitmask |= PARENTID_COLUMN_BITMASK;

        if (!_setOriginalParentId) {
            _setOriginalParentId = true;

            _originalParentId = _parentId;
        }

        _parentId = parentId;
    }

    public Integer getOriginalParentId() {
        return _originalParentId;
    }

    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFQuizQuestionCategory.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFQuizQuestionCategory toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (LFQuizQuestionCategory) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        LFQuizQuestionCategoryImpl lfQuizQuestionCategoryImpl = new LFQuizQuestionCategoryImpl();

        lfQuizQuestionCategoryImpl.setId(getId());
        lfQuizQuestionCategoryImpl.setTitle(getTitle());
        lfQuizQuestionCategoryImpl.setDescription(getDescription());
        lfQuizQuestionCategoryImpl.setQuizId(getQuizId());
        lfQuizQuestionCategoryImpl.setParentId(getParentId());
        lfQuizQuestionCategoryImpl.setArrangementIndex(getArrangementIndex());

        lfQuizQuestionCategoryImpl.resetOriginalValues();

        return lfQuizQuestionCategoryImpl;
    }

    public int compareTo(LFQuizQuestionCategory lfQuizQuestionCategory) {
        long primaryKey = lfQuizQuestionCategory.getPrimaryKey();

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

        LFQuizQuestionCategory lfQuizQuestionCategory = null;

        try {
            lfQuizQuestionCategory = (LFQuizQuestionCategory) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfQuizQuestionCategory.getPrimaryKey();

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
        LFQuizQuestionCategoryModelImpl lfQuizQuestionCategoryModelImpl = this;

        lfQuizQuestionCategoryModelImpl._originalQuizId = lfQuizQuestionCategoryModelImpl._quizId;

        lfQuizQuestionCategoryModelImpl._setOriginalQuizId = false;

        lfQuizQuestionCategoryModelImpl._originalParentId = lfQuizQuestionCategoryModelImpl._parentId;

        lfQuizQuestionCategoryModelImpl._setOriginalParentId = false;

        lfQuizQuestionCategoryModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFQuizQuestionCategory> toCacheModel() {
        LFQuizQuestionCategoryCacheModel lfQuizQuestionCategoryCacheModel = new LFQuizQuestionCategoryCacheModel();

        lfQuizQuestionCategoryCacheModel.id = getId();

        lfQuizQuestionCategoryCacheModel.title = getTitle();

        String title = lfQuizQuestionCategoryCacheModel.title;

        if ((title != null) && (title.length() == 0)) {
            lfQuizQuestionCategoryCacheModel.title = null;
        }

        lfQuizQuestionCategoryCacheModel.description = getDescription();

        String description = lfQuizQuestionCategoryCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            lfQuizQuestionCategoryCacheModel.description = null;
        }

        lfQuizQuestionCategoryCacheModel.quizId = getQuizId();

        lfQuizQuestionCategoryCacheModel.parentId = getParentId();

        lfQuizQuestionCategoryCacheModel.arrangementIndex = getArrangementIndex();

        return lfQuizQuestionCategoryCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", quizId=");
        sb.append(getQuizId());
        sb.append(", parentId=");
        sb.append(getParentId());
        sb.append(", arrangementIndex=");
        sb.append(getArrangementIndex());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quizId</column-name><column-value><![CDATA[");
        sb.append(getQuizId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentId</column-name><column-value><![CDATA[");
        sb.append(getParentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>arrangementIndex</column-name><column-value><![CDATA[");
        sb.append(getArrangementIndex());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
