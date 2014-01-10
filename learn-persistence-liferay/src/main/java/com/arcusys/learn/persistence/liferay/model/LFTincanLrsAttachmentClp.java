package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFTincanLrsAttachmentClp extends BaseModelImpl<LFTincanLrsAttachment>
    implements LFTincanLrsAttachment {
    private long _id;
    private Integer _parentID;
    private String _usageType;
    private String _display;
    private String _description;
    private String _contentType;
    private Integer _length;
    private String _sha2;
    private String _fileUrl;
    private BaseModel<?> _lfTincanLrsAttachmentRemoteModel;

    public LFTincanLrsAttachmentClp() {
    }

    public Class<?> getModelClass() {
        return LFTincanLrsAttachment.class;
    }

    public String getModelClassName() {
        return LFTincanLrsAttachment.class.getName();
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
        attributes.put("parentID", getParentID());
        attributes.put("usageType", getUsageType());
        attributes.put("display", getDisplay());
        attributes.put("description", getDescription());
        attributes.put("contentType", getContentType());
        attributes.put("length", getLength());
        attributes.put("sha2", getSha2());
        attributes.put("fileUrl", getFileUrl());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer parentID = (Integer) attributes.get("parentID");

        if (parentID != null) {
            setParentID(parentID);
        }

        String usageType = (String) attributes.get("usageType");

        if (usageType != null) {
            setUsageType(usageType);
        }

        String display = (String) attributes.get("display");

        if (display != null) {
            setDisplay(display);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String contentType = (String) attributes.get("contentType");

        if (contentType != null) {
            setContentType(contentType);
        }

        Integer length = (Integer) attributes.get("length");

        if (length != null) {
            setLength(length);
        }

        String sha2 = (String) attributes.get("sha2");

        if (sha2 != null) {
            setSha2(sha2);
        }

        String fileUrl = (String) attributes.get("fileUrl");

        if (fileUrl != null) {
            setFileUrl(fileUrl);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getParentID() {
        return _parentID;
    }

    public void setParentID(Integer parentID) {
        _parentID = parentID;
    }

    public String getUsageType() {
        return _usageType;
    }

    public void setUsageType(String usageType) {
        _usageType = usageType;
    }

    public String getDisplay() {
        return _display;
    }

    public void setDisplay(String display) {
        _display = display;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getContentType() {
        return _contentType;
    }

    public void setContentType(String contentType) {
        _contentType = contentType;
    }

    public Integer getLength() {
        return _length;
    }

    public void setLength(Integer length) {
        _length = length;
    }

    public String getSha2() {
        return _sha2;
    }

    public void setSha2(String sha2) {
        _sha2 = sha2;
    }

    public String getFileUrl() {
        return _fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        _fileUrl = fileUrl;
    }

    public BaseModel<?> getLFTincanLrsAttachmentRemoteModel() {
        return _lfTincanLrsAttachmentRemoteModel;
    }

    public void setLFTincanLrsAttachmentRemoteModel(
        BaseModel<?> lfTincanLrsAttachmentRemoteModel) {
        _lfTincanLrsAttachmentRemoteModel = lfTincanLrsAttachmentRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsAttachmentLocalServiceUtil.addLFTincanLrsAttachment(this);
        } else {
            LFTincanLrsAttachmentLocalServiceUtil.updateLFTincanLrsAttachment(this);
        }
    }

    @Override
    public LFTincanLrsAttachment toEscapedModel() {
        return (LFTincanLrsAttachment) Proxy.newProxyInstance(LFTincanLrsAttachment.class.getClassLoader(),
            new Class[] { LFTincanLrsAttachment.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsAttachmentClp clone = new LFTincanLrsAttachmentClp();

        clone.setId(getId());
        clone.setParentID(getParentID());
        clone.setUsageType(getUsageType());
        clone.setDisplay(getDisplay());
        clone.setDescription(getDescription());
        clone.setContentType(getContentType());
        clone.setLength(getLength());
        clone.setSha2(getSha2());
        clone.setFileUrl(getFileUrl());

        return clone;
    }

    public int compareTo(LFTincanLrsAttachment lfTincanLrsAttachment) {
        long primaryKey = lfTincanLrsAttachment.getPrimaryKey();

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

        LFTincanLrsAttachmentClp lfTincanLrsAttachment = null;

        try {
            lfTincanLrsAttachment = (LFTincanLrsAttachmentClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfTincanLrsAttachment.getPrimaryKey();

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
        StringBundler sb = new StringBundler(19);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", parentID=");
        sb.append(getParentID());
        sb.append(", usageType=");
        sb.append(getUsageType());
        sb.append(", display=");
        sb.append(getDisplay());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", contentType=");
        sb.append(getContentType());
        sb.append(", length=");
        sb.append(getLength());
        sb.append(", sha2=");
        sb.append(getSha2());
        sb.append(", fileUrl=");
        sb.append(getFileUrl());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentID</column-name><column-value><![CDATA[");
        sb.append(getParentID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>usageType</column-name><column-value><![CDATA[");
        sb.append(getUsageType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>display</column-name><column-value><![CDATA[");
        sb.append(getDisplay());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contentType</column-name><column-value><![CDATA[");
        sb.append(getContentType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>length</column-name><column-value><![CDATA[");
        sb.append(getLength());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sha2</column-name><column-value><![CDATA[");
        sb.append(getSha2());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileUrl</column-name><column-value><![CDATA[");
        sb.append(getFileUrl());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
