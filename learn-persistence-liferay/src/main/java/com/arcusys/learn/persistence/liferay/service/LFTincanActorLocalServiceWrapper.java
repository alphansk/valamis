package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanActorLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFTincanActorLocalService
 * @generated
 */
public class LFTincanActorLocalServiceWrapper
    implements LFTincanActorLocalService,
        ServiceWrapper<LFTincanActorLocalService> {
    private LFTincanActorLocalService _lfTincanActorLocalService;

    public LFTincanActorLocalServiceWrapper(
        LFTincanActorLocalService lfTincanActorLocalService) {
        _lfTincanActorLocalService = lfTincanActorLocalService;
    }

    /**
    * Adds the l f tincan actor to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActor the l f tincan actor
    * @return the l f tincan actor that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor addLFTincanActor(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.addLFTincanActor(lfTincanActor);
    }

    /**
    * Creates a new l f tincan actor with the primary key. Does not add the l f tincan actor to the database.
    *
    * @param id the primary key for the new l f tincan actor
    * @return the new l f tincan actor
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor createLFTincanActor(
        long id) {
        return _lfTincanActorLocalService.createLFTincanActor(id);
    }

    /**
    * Deletes the l f tincan actor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor that was removed
    * @throws PortalException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor deleteLFTincanActor(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.deleteLFTincanActor(id);
    }

    /**
    * Deletes the l f tincan actor from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActor the l f tincan actor
    * @return the l f tincan actor that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor deleteLFTincanActor(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.deleteLFTincanActor(lfTincanActor);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanActorLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanActor fetchLFTincanActor(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.fetchLFTincanActor(id);
    }

    /**
    * Returns the l f tincan actor with the primary key.
    *
    * @param id the primary key of the l f tincan actor
    * @return the l f tincan actor
    * @throws PortalException if a l f tincan actor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor getLFTincanActor(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.getLFTincanActor(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan actors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan actors
    * @param end the upper bound of the range of l f tincan actors (not inclusive)
    * @return the range of l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> getLFTincanActors(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.getLFTincanActors(start, end);
    }

    /**
    * Returns the number of l f tincan actors.
    *
    * @return the number of l f tincan actors
    * @throws SystemException if a system exception occurred
    */
    public int getLFTincanActorsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.getLFTincanActorsCount();
    }

    /**
    * Updates the l f tincan actor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActor the l f tincan actor
    * @return the l f tincan actor that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor updateLFTincanActor(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.updateLFTincanActor(lfTincanActor);
    }

    /**
    * Updates the l f tincan actor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActor the l f tincan actor
    * @param merge whether to merge the l f tincan actor with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan actor that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActor updateLFTincanActor(
        com.arcusys.learn.persistence.liferay.model.LFTincanActor lfTincanActor,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.updateLFTincanActor(lfTincanActor,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfTincanActorLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanActorLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanActorLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanActorLocalService.removeAll();
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanActor createLFTincanActor()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.createLFTincanActor();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findByMemberOf(
        java.lang.String memberOf)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.findByMemberOf(memberOf);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanActor findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.findByTincanID(tincanID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActor> findAgent(
        java.lang.String name, java.lang.String mbox,
        java.lang.String mbox_sha1sum, java.lang.String openid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActorLocalService.findAgent(name, mbox, mbox_sha1sum,
            openid);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFTincanActorLocalService getWrappedLFTincanActorLocalService() {
        return _lfTincanActorLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFTincanActorLocalService(
        LFTincanActorLocalService lfTincanActorLocalService) {
        _lfTincanActorLocalService = lfTincanActorLocalService;
    }

    public LFTincanActorLocalService getWrappedService() {
        return _lfTincanActorLocalService;
    }

    public void setWrappedService(
        LFTincanActorLocalService lfTincanActorLocalService) {
        _lfTincanActorLocalService = lfTincanActorLocalService;
    }
}
