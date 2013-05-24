package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFActivityStateTreeLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFActivityStateTreeLocalService
 * @generated
 */
public class LFActivityStateTreeLocalServiceWrapper
    implements LFActivityStateTreeLocalService,
        ServiceWrapper<LFActivityStateTreeLocalService> {
    private LFActivityStateTreeLocalService _lfActivityStateTreeLocalService;

    public LFActivityStateTreeLocalServiceWrapper(
        LFActivityStateTreeLocalService lfActivityStateTreeLocalService) {
        _lfActivityStateTreeLocalService = lfActivityStateTreeLocalService;
    }

    /**
    * Adds the l f activity state tree to the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @return the l f activity state tree that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree addLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.addLFActivityStateTree(lfActivityStateTree);
    }

    /**
    * Creates a new l f activity state tree with the primary key. Does not add the l f activity state tree to the database.
    *
    * @param id the primary key for the new l f activity state tree
    * @return the new l f activity state tree
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree createLFActivityStateTree(
        long id) {
        return _lfActivityStateTreeLocalService.createLFActivityStateTree(id);
    }

    /**
    * Deletes the l f activity state tree with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree that was removed
    * @throws PortalException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree deleteLFActivityStateTree(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.deleteLFActivityStateTree(id);
    }

    /**
    * Deletes the l f activity state tree from the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @return the l f activity state tree that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree deleteLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.deleteLFActivityStateTree(lfActivityStateTree);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfActivityStateTreeLocalService.dynamicQuery();
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
        return _lfActivityStateTreeLocalService.dynamicQuery(dynamicQuery);
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
        return _lfActivityStateTreeLocalService.dynamicQuery(dynamicQuery,
            start, end);
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
        return _lfActivityStateTreeLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _lfActivityStateTreeLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree fetchLFActivityStateTree(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.fetchLFActivityStateTree(id);
    }

    /**
    * Returns the l f activity state tree with the primary key.
    *
    * @param id the primary key of the l f activity state tree
    * @return the l f activity state tree
    * @throws PortalException if a l f activity state tree with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree getLFActivityStateTree(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.getLFActivityStateTree(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f activity state trees.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity state trees
    * @param end the upper bound of the range of l f activity state trees (not inclusive)
    * @return the range of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityStateTree> getLFActivityStateTrees(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.getLFActivityStateTrees(start,
            end);
    }

    /**
    * Returns the number of l f activity state trees.
    *
    * @return the number of l f activity state trees
    * @throws SystemException if a system exception occurred
    */
    public int getLFActivityStateTreesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.getLFActivityStateTreesCount();
    }

    /**
    * Updates the l f activity state tree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @return the l f activity state tree that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree updateLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.updateLFActivityStateTree(lfActivityStateTree);
    }

    /**
    * Updates the l f activity state tree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivityStateTree the l f activity state tree
    * @param merge whether to merge the l f activity state tree with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f activity state tree that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree updateLFActivityStateTree(
        com.arcusys.learn.persistence.liferay.model.LFActivityStateTree lfActivityStateTree,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.updateLFActivityStateTree(lfActivityStateTree,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfActivityStateTreeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfActivityStateTreeLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfActivityStateTreeLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree createLFActivityStateTree()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.createLFActivityStateTree();
    }

    public com.arcusys.learn.persistence.liferay.model.LFActivityStateTree findByAttemptID(
        java.lang.Integer attemptID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateTreeLocalService.findByAttemptID(attemptID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityStateTreeLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFActivityStateTreeLocalService getWrappedLFActivityStateTreeLocalService() {
        return _lfActivityStateTreeLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFActivityStateTreeLocalService(
        LFActivityStateTreeLocalService lfActivityStateTreeLocalService) {
        _lfActivityStateTreeLocalService = lfActivityStateTreeLocalService;
    }

    public LFActivityStateTreeLocalService getWrappedService() {
        return _lfActivityStateTreeLocalService;
    }

    public void setWrappedService(
        LFActivityStateTreeLocalService lfActivityStateTreeLocalService) {
        _lfActivityStateTreeLocalService = lfActivityStateTreeLocalService;
    }
}
