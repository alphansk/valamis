package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsActivityProfileLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFTincanLrsActivityProfileClp extends BaseModelImpl<LFTincanLrsActivityProfile>
    implements LFTincanLrsActivityProfile {
    private long _id;
    private Integer _documentId;
    private String _activityId;
    private String _profileId;
    private BaseModel<?> _lfTincanLrsActivityProfileRemoteModel;

    public LFTincanLrsActivityProfileClp() {
    }

    public Class<?> getModelClass() {
        return LFTincanLrsActivityProfile.class;
    }

    public String getModelClassName() {
        return LFTincanLrsActivityProfile.class.getName();
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
        attributes.put("documentId", getDocumentId());
        attributes.put("activityId", getActivityId());
        attributes.put("profileId", getProfileId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer documentId = (Integer) attributes.get("documentId");

        if (documentId != null) {
            setDocumentId(documentId);
        }

        String activityId = (String) attributes.get("activityId");

        if (activityId != null) {
            setActivityId(activityId);
        }

        String profileId = (String) attributes.get("profileId");

        if (profileId != null) {
            setProfileId(profileId);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(Integer documentId) {
        _documentId = documentId;
    }

    public String getActivityId() {
        return _activityId;
    }

    public void setActivityId(String activityId) {
        _activityId = activityId;
    }

    public String getProfileId() {
        return _profileId;
    }

    public void setProfileId(String profileId) {
        _profileId = profileId;
    }

    public BaseModel<?> getLFTincanLrsActivityProfileRemoteModel() {
        return _lfTincanLrsActivityProfileRemoteModel;
    }

    public void setLFTincanLrsActivityProfileRemoteModel(
        BaseModel<?> lfTincanLrsActivityProfileRemoteModel) {
        _lfTincanLrsActivityProfileRemoteModel = lfTincanLrsActivityProfileRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsActivityProfileLocalServiceUtil.addLFTincanLrsActivityProfile(this);
        } else {
            LFTincanLrsActivityProfileLocalServiceUtil.updateLFTincanLrsActivityProfile(this);
        }
    }

    @Override
    public LFTincanLrsActivityProfile toEscapedModel() {
        return (LFTincanLrsActivityProfile) Proxy.newProxyInstance(LFTincanLrsActivityProfile.class.getClassLoader(),
            new Class[] { LFTincanLrsActivityProfile.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsActivityProfileClp clone = new LFTincanLrsActivityProfileClp();

        clone.setId(getId());
        clone.setDocumentId(getDocumentId());
        clone.setActivityId(getActivityId());
        clone.setProfileId(getProfileId());

        return clone;
    }

    public int compareTo(LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        long primaryKey = lfTincanLrsActivityProfile.getPrimaryKey();

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

        LFTincanLrsActivityProfileClp lfTincanLrsActivityProfile = null;

        try {
            lfTincanLrsActivityProfile = (LFTincanLrsActivityProfileClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfTincanLrsActivityProfile.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", documentId=");
        sb.append(getDocumentId());
        sb.append(", activityId=");
        sb.append(getActivityId());
        sb.append(", profileId=");
        sb.append(getProfileId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>documentId</column-name><column-value><![CDATA[");
        sb.append(getDocumentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityId</column-name><column-value><![CDATA[");
        sb.append(getActivityId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>profileId</column-name><column-value><![CDATA[");
        sb.append(getProfileId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
