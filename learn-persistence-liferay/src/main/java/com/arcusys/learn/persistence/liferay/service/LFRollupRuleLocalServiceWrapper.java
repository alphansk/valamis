package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFRollupRuleLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFRollupRuleLocalService
 * @generated
 */
public class LFRollupRuleLocalServiceWrapper implements LFRollupRuleLocalService,
    ServiceWrapper<LFRollupRuleLocalService> {
    private LFRollupRuleLocalService _lfRollupRuleLocalService;

    public LFRollupRuleLocalServiceWrapper(
        LFRollupRuleLocalService lfRollupRuleLocalService) {
        _lfRollupRuleLocalService = lfRollupRuleLocalService;
    }

    /**
    * Adds the l f rollup rule to the database. Also notifies the appropriate model listeners.
    *
    * @param lfRollupRule the l f rollup rule
    * @return the l f rollup rule that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupRule addLFRollupRule(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.addLFRollupRule(lfRollupRule);
    }

    /**
    * Creates a new l f rollup rule with the primary key. Does not add the l f rollup rule to the database.
    *
    * @param id the primary key for the new l f rollup rule
    * @return the new l f rollup rule
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupRule createLFRollupRule(
        long id) {
        return _lfRollupRuleLocalService.createLFRollupRule(id);
    }

    /**
    * Deletes the l f rollup rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f rollup rule
    * @return the l f rollup rule that was removed
    * @throws PortalException if a l f rollup rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupRule deleteLFRollupRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.deleteLFRollupRule(id);
    }

    /**
    * Deletes the l f rollup rule from the database. Also notifies the appropriate model listeners.
    *
    * @param lfRollupRule the l f rollup rule
    * @return the l f rollup rule that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupRule deleteLFRollupRule(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.deleteLFRollupRule(lfRollupRule);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfRollupRuleLocalService.dynamicQuery();
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
        return _lfRollupRuleLocalService.dynamicQuery(dynamicQuery);
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
        return _lfRollupRuleLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _lfRollupRuleLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _lfRollupRuleLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFRollupRule fetchLFRollupRule(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.fetchLFRollupRule(id);
    }

    /**
    * Returns the l f rollup rule with the primary key.
    *
    * @param id the primary key of the l f rollup rule
    * @return the l f rollup rule
    * @throws PortalException if a l f rollup rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupRule getLFRollupRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.getLFRollupRule(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f rollup rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f rollup rules
    * @param end the upper bound of the range of l f rollup rules (not inclusive)
    * @return the range of l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> getLFRollupRules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.getLFRollupRules(start, end);
    }

    /**
    * Returns the number of l f rollup rules.
    *
    * @return the number of l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public int getLFRollupRulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.getLFRollupRulesCount();
    }

    /**
    * Updates the l f rollup rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRollupRule the l f rollup rule
    * @return the l f rollup rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupRule updateLFRollupRule(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.updateLFRollupRule(lfRollupRule);
    }

    /**
    * Updates the l f rollup rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRollupRule the l f rollup rule
    * @param merge whether to merge the l f rollup rule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f rollup rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupRule updateLFRollupRule(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.updateLFRollupRule(lfRollupRule, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfRollupRuleLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfRollupRuleLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfRollupRuleLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFRollupRule createLFRollupRule()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.createLFRollupRule();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupRuleLocalService.findBySequencingID(sequencingID);
    }

    public void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRollupRuleLocalService.removeBySequencingID(sequencingID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRollupRuleLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFRollupRuleLocalService getWrappedLFRollupRuleLocalService() {
        return _lfRollupRuleLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFRollupRuleLocalService(
        LFRollupRuleLocalService lfRollupRuleLocalService) {
        _lfRollupRuleLocalService = lfRollupRuleLocalService;
    }

    public LFRollupRuleLocalService getWrappedService() {
        return _lfRollupRuleLocalService;
    }

    public void setWrappedService(
        LFRollupRuleLocalService lfRollupRuleLocalService) {
        _lfRollupRuleLocalService = lfRollupRuleLocalService;
    }
}
