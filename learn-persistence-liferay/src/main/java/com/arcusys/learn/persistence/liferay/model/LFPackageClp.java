package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFPackageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFPackageClp extends BaseModelImpl<LFPackage> implements LFPackage {
    private long _id;
    private String _defaultOrganizationID;
    private String _title;
    private String _base;
    private String _resourcesBase;
    private String _summary;
    private Long _assetRefID;
    private Integer _courseID;
    private BaseModel<?> _lfPackageRemoteModel;

    public LFPackageClp() {
    }

    public Class<?> getModelClass() {
        return LFPackage.class;
    }

    public String getModelClassName() {
        return LFPackage.class.getName();
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

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("defaultOrganizationID", getDefaultOrganizationID());
        attributes.put("title", getTitle());
        attributes.put("base", getBase());
        attributes.put("resourcesBase", getResourcesBase());
        attributes.put("summary", getSummary());
        attributes.put("assetRefID", getAssetRefID());
        attributes.put("courseID", getCourseID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String defaultOrganizationID = (String) attributes.get(
                "defaultOrganizationID");

        if (defaultOrganizationID != null) {
            setDefaultOrganizationID(defaultOrganizationID);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String base = (String) attributes.get("base");

        if (base != null) {
            setBase(base);
        }

        String resourcesBase = (String) attributes.get("resourcesBase");

        if (resourcesBase != null) {
            setResourcesBase(resourcesBase);
        }

        String summary = (String) attributes.get("summary");

        if (summary != null) {
            setSummary(summary);
        }

        Long assetRefID = (Long) attributes.get("assetRefID");

        if (assetRefID != null) {
            setAssetRefID(assetRefID);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getDefaultOrganizationID() {
        return _defaultOrganizationID;
    }

    public void setDefaultOrganizationID(String defaultOrganizationID) {
        _defaultOrganizationID = defaultOrganizationID;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getBase() {
        return _base;
    }

    public void setBase(String base) {
        _base = base;
    }

    public String getResourcesBase() {
        return _resourcesBase;
    }

    public void setResourcesBase(String resourcesBase) {
        _resourcesBase = resourcesBase;
    }

    public String getSummary() {
        return _summary;
    }

    public void setSummary(String summary) {
        _summary = summary;
    }

    public Long getAssetRefID() {
        return _assetRefID;
    }

    public void setAssetRefID(Long assetRefID) {
        _assetRefID = assetRefID;
    }

    public Integer getCourseID() {
        return _courseID;
    }

    public void setCourseID(Integer courseID) {
        _courseID = courseID;
    }

    public BaseModel<?> getLFPackageRemoteModel() {
        return _lfPackageRemoteModel;
    }

    public void setLFPackageRemoteModel(BaseModel<?> lfPackageRemoteModel) {
        _lfPackageRemoteModel = lfPackageRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPackageLocalServiceUtil.addLFPackage(this);
        } else {
            LFPackageLocalServiceUtil.updateLFPackage(this);
        }
    }

    @Override
    public LFPackage toEscapedModel() {
        return (LFPackage) Proxy.newProxyInstance(LFPackage.class.getClassLoader(),
            new Class[] { LFPackage.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFPackageClp clone = new LFPackageClp();

        clone.setId(getId());
        clone.setDefaultOrganizationID(getDefaultOrganizationID());
        clone.setTitle(getTitle());
        clone.setBase(getBase());
        clone.setResourcesBase(getResourcesBase());
        clone.setSummary(getSummary());
        clone.setAssetRefID(getAssetRefID());
        clone.setCourseID(getCourseID());

        return clone;
    }

    public int compareTo(LFPackage lfPackage) {
        long primaryKey = lfPackage.getPrimaryKey();

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

        LFPackageClp lfPackage = null;

        try {
            lfPackage = (LFPackageClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfPackage.getPrimaryKey();

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
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", defaultOrganizationID=");
        sb.append(getDefaultOrganizationID());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", base=");
        sb.append(getBase());
        sb.append(", resourcesBase=");
        sb.append(getResourcesBase());
        sb.append(", summary=");
        sb.append(getSummary());
        sb.append(", assetRefID=");
        sb.append(getAssetRefID());
        sb.append(", courseID=");
        sb.append(getCourseID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFPackage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>defaultOrganizationID</column-name><column-value><![CDATA[");
        sb.append(getDefaultOrganizationID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>base</column-name><column-value><![CDATA[");
        sb.append(getBase());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resourcesBase</column-name><column-value><![CDATA[");
        sb.append(getResourcesBase());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>summary</column-name><column-value><![CDATA[");
        sb.append(getSummary());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>assetRefID</column-name><column-value><![CDATA[");
        sb.append(getAssetRefID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseID</column-name><column-value><![CDATA[");
        sb.append(getCourseID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
