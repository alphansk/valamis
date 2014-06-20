package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the LFFileStorage service. Represents a row in the &quot;Learn_LFFileStorage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFFileStorage
 * @see com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageImpl
 * @see com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl
 * @generated
 */
public interface LFFileStorageModel extends BaseModel<LFFileStorage> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a l f file storage model instance should use the {@link LFFileStorage} interface instead.
     */

    /**
     * Returns the primary key of this l f file storage.
     *
     * @return the primary key of this l f file storage
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this l f file storage.
     *
     * @param primaryKey the primary key of this l f file storage
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this l f file storage.
     *
     * @return the ID of this l f file storage
     */
    public long getId();

    /**
     * Sets the ID of this l f file storage.
     *
     * @param id the ID of this l f file storage
     */
    public void setId(long id);

    /**
     * Returns the filename of this l f file storage.
     *
     * @return the filename of this l f file storage
     */
    @AutoEscape
    public String getFilename();

    /**
     * Sets the filename of this l f file storage.
     *
     * @param filename the filename of this l f file storage
     */
    public void setFilename(String filename);

    /**
     * Returns the content of this l f file storage.
     *
     * @return the content of this l f file storage
     */
    @AutoEscape
    public String getContent();

    /**
     * Sets the content of this l f file storage.
     *
     * @param content the content of this l f file storage
     */
    public void setContent(String content);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(LFFileStorage lfFileStorage);

    @Override
    public int hashCode();

    @Override
    public CacheModel<LFFileStorage> toCacheModel();

    @Override
    public LFFileStorage toEscapedModel();

    @Override
    public LFFileStorage toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}