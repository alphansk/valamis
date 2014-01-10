package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException;
import com.arcusys.learn.persistence.liferay.model.LFObjective;
import com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityDataMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateNodePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateTreePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAnswerPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptDataPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFBigDecimalPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateSitePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFChildrenSelectionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConditionRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConfigPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCoursePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFFileStoragePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFGlobalObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectivePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageCommentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageVotePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPlayerScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFResourcePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRolePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupContributionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRuleConditionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPermissionsPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingTrackingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackageTagPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActorPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsActivityProfilePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsAgentProfilePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsAttachmentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsContextActivitiesPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsContextPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsDocumentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsEndpointPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsResultPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementRefPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsSubStatementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanManifestActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFUserPersistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l f objective service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectivePersistence
 * @see LFObjectiveUtil
 * @generated
 */
public class LFObjectivePersistenceImpl extends BasePersistenceImpl<LFObjective>
    implements LFObjectivePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFObjectiveUtil} to access the l f objective persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFObjectiveImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySequencingIDAndIsPrimary",
            new String[] {
                Integer.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBySequencingIDAndIsPrimary",
            new String[] { Integer.class.getName(), Boolean.class.getName() },
            LFObjectiveModelImpl.SEQUENCINGID_COLUMN_BITMASK |
            LFObjectiveModelImpl.ISPRIMARY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARY =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySequencingIDAndIsPrimary",
            new String[] { Integer.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySequencingIDAndIsPrimaryAndIdentifier",
            new String[] {
                Integer.class.getName(), Boolean.class.getName(),
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBySequencingIDAndIsPrimaryAndIdentifier",
            new String[] {
                Integer.class.getName(), Boolean.class.getName(),
                String.class.getName()
            },
            LFObjectiveModelImpl.SEQUENCINGID_COLUMN_BITMASK |
            LFObjectiveModelImpl.ISPRIMARY_COLUMN_BITMASK |
            LFObjectiveModelImpl.IDENTIFIER_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER =
        new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySequencingIDAndIsPrimaryAndIdentifier",
            new String[] {
                Integer.class.getName(), Boolean.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, LFObjectiveImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFOBJECTIVE = "SELECT lfObjective FROM LFObjective lfObjective";
    private static final String _SQL_SELECT_LFOBJECTIVE_WHERE = "SELECT lfObjective FROM LFObjective lfObjective WHERE ";
    private static final String _SQL_COUNT_LFOBJECTIVE = "SELECT COUNT(lfObjective) FROM LFObjective lfObjective";
    private static final String _SQL_COUNT_LFOBJECTIVE_WHERE = "SELECT COUNT(lfObjective) FROM LFObjective lfObjective WHERE ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL =
        "lfObjective.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL_2 =
        "lfObjective.sequencingID IS NULL  AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_2 =
        "lfObjective.sequencingID = ? AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL =
        "lfObjective.isPrimary IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL_2 =
        "lfObjective.isPrimary IS NULL ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_2 =
        "lfObjective.isPrimary = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_SEQUENCINGID_NULL =
        "lfObjective.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_SEQUENCINGID_NULL_2 =
        "lfObjective.sequencingID IS NULL  AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_SEQUENCINGID_2 =
        "lfObjective.sequencingID = ? AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_ISPRIMARY_NULL =
        "lfObjective.isPrimary IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_ISPRIMARY_NULL_2 =
        "lfObjective.isPrimary IS NULL  AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_ISPRIMARY_2 =
        "lfObjective.isPrimary = ? AND ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_1 =
        "lfObjective.identifier IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_NULL =
        "lfObjective.identifier IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_NULL_2 =
        "lfObjective.identifier IS NULL ";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_2 =
        "lfObjective.identifier = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_3 =
        "(lfObjective.identifier IS NULL OR lfObjective.identifier = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfObjective.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFObjective exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFObjective exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFObjectivePersistenceImpl.class);
    private static LFObjective _nullLFObjective = new LFObjectiveImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFObjective> toCacheModel() {
                return _nullLFObjectiveCacheModel;
            }
        };

    private static CacheModel<LFObjective> _nullLFObjectiveCacheModel = new CacheModel<LFObjective>() {
            public LFObjective toEntityModel() {
                return _nullLFObjective;
            }
        };

    @BeanReference(type = LFActivityPersistence.class)
    protected LFActivityPersistence lfActivityPersistence;
    @BeanReference(type = LFActivityDataMapPersistence.class)
    protected LFActivityDataMapPersistence lfActivityDataMapPersistence;
    @BeanReference(type = LFActivityStatePersistence.class)
    protected LFActivityStatePersistence lfActivityStatePersistence;
    @BeanReference(type = LFActivityStateNodePersistence.class)
    protected LFActivityStateNodePersistence lfActivityStateNodePersistence;
    @BeanReference(type = LFActivityStateTreePersistence.class)
    protected LFActivityStateTreePersistence lfActivityStateTreePersistence;
    @BeanReference(type = LFAnswerPersistence.class)
    protected LFAnswerPersistence lfAnswerPersistence;
    @BeanReference(type = LFAttemptPersistence.class)
    protected LFAttemptPersistence lfAttemptPersistence;
    @BeanReference(type = LFAttemptDataPersistence.class)
    protected LFAttemptDataPersistence lfAttemptDataPersistence;
    @BeanReference(type = LFBigDecimalPersistence.class)
    protected LFBigDecimalPersistence lfBigDecimalPersistence;
    @BeanReference(type = LFCertificatePersistence.class)
    protected LFCertificatePersistence lfCertificatePersistence;
    @BeanReference(type = LFCertificateSitePersistence.class)
    protected LFCertificateSitePersistence lfCertificateSitePersistence;
    @BeanReference(type = LFCertificateUserPersistence.class)
    protected LFCertificateUserPersistence lfCertificateUserPersistence;
    @BeanReference(type = LFChildrenSelectionPersistence.class)
    protected LFChildrenSelectionPersistence lfChildrenSelectionPersistence;
    @BeanReference(type = LFConditionRulePersistence.class)
    protected LFConditionRulePersistence lfConditionRulePersistence;
    @BeanReference(type = LFConfigPersistence.class)
    protected LFConfigPersistence lfConfigPersistence;
    @BeanReference(type = LFCoursePersistence.class)
    protected LFCoursePersistence lfCoursePersistence;
    @BeanReference(type = LFFileStoragePersistence.class)
    protected LFFileStoragePersistence lfFileStoragePersistence;
    @BeanReference(type = LFGlobalObjectiveStatePersistence.class)
    protected LFGlobalObjectiveStatePersistence lfGlobalObjectiveStatePersistence;
    @BeanReference(type = LFObjectivePersistence.class)
    protected LFObjectivePersistence lfObjectivePersistence;
    @BeanReference(type = LFObjectiveMapPersistence.class)
    protected LFObjectiveMapPersistence lfObjectiveMapPersistence;
    @BeanReference(type = LFObjectiveStatePersistence.class)
    protected LFObjectiveStatePersistence lfObjectiveStatePersistence;
    @BeanReference(type = LFPackagePersistence.class)
    protected LFPackagePersistence lfPackagePersistence;
    @BeanReference(type = LFPackageCommentPersistence.class)
    protected LFPackageCommentPersistence lfPackageCommentPersistence;
    @BeanReference(type = LFPackageScopeRulePersistence.class)
    protected LFPackageScopeRulePersistence lfPackageScopeRulePersistence;
    @BeanReference(type = LFPackageVotePersistence.class)
    protected LFPackageVotePersistence lfPackageVotePersistence;
    @BeanReference(type = LFPlayerScopeRulePersistence.class)
    protected LFPlayerScopeRulePersistence lfPlayerScopeRulePersistence;
    @BeanReference(type = LFQuestionPersistence.class)
    protected LFQuestionPersistence lfQuestionPersistence;
    @BeanReference(type = LFQuestionCategoryPersistence.class)
    protected LFQuestionCategoryPersistence lfQuestionCategoryPersistence;
    @BeanReference(type = LFQuizPersistence.class)
    protected LFQuizPersistence lfQuizPersistence;
    @BeanReference(type = LFQuizQuestionPersistence.class)
    protected LFQuizQuestionPersistence lfQuizQuestionPersistence;
    @BeanReference(type = LFQuizQuestionCategoryPersistence.class)
    protected LFQuizQuestionCategoryPersistence lfQuizQuestionCategoryPersistence;
    @BeanReference(type = LFResourcePersistence.class)
    protected LFResourcePersistence lfResourcePersistence;
    @BeanReference(type = LFRolePersistence.class)
    protected LFRolePersistence lfRolePersistence;
    @BeanReference(type = LFRollupContributionPersistence.class)
    protected LFRollupContributionPersistence lfRollupContributionPersistence;
    @BeanReference(type = LFRollupRulePersistence.class)
    protected LFRollupRulePersistence lfRollupRulePersistence;
    @BeanReference(type = LFRuleConditionPersistence.class)
    protected LFRuleConditionPersistence lfRuleConditionPersistence;
    @BeanReference(type = LFSequencingPersistence.class)
    protected LFSequencingPersistence lfSequencingPersistence;
    @BeanReference(type = LFSequencingPermissionsPersistence.class)
    protected LFSequencingPermissionsPersistence lfSequencingPermissionsPersistence;
    @BeanReference(type = LFSequencingTrackingPersistence.class)
    protected LFSequencingTrackingPersistence lfSequencingTrackingPersistence;
    @BeanReference(type = LFSocialPackagePersistence.class)
    protected LFSocialPackagePersistence lfSocialPackagePersistence;
    @BeanReference(type = LFSocialPackageTagPersistence.class)
    protected LFSocialPackageTagPersistence lfSocialPackageTagPersistence;
    @BeanReference(type = LFTincanActivityPersistence.class)
    protected LFTincanActivityPersistence lfTincanActivityPersistence;
    @BeanReference(type = LFTincanActorPersistence.class)
    protected LFTincanActorPersistence lfTincanActorPersistence;
    @BeanReference(type = LFTincanLrsActivityProfilePersistence.class)
    protected LFTincanLrsActivityProfilePersistence lfTincanLrsActivityProfilePersistence;
    @BeanReference(type = LFTincanLrsAgentProfilePersistence.class)
    protected LFTincanLrsAgentProfilePersistence lfTincanLrsAgentProfilePersistence;
    @BeanReference(type = LFTincanLrsAttachmentPersistence.class)
    protected LFTincanLrsAttachmentPersistence lfTincanLrsAttachmentPersistence;
    @BeanReference(type = LFTincanLrsContextPersistence.class)
    protected LFTincanLrsContextPersistence lfTincanLrsContextPersistence;
    @BeanReference(type = LFTincanLrsContextActivitiesPersistence.class)
    protected LFTincanLrsContextActivitiesPersistence lfTincanLrsContextActivitiesPersistence;
    @BeanReference(type = LFTincanLrsDocumentPersistence.class)
    protected LFTincanLrsDocumentPersistence lfTincanLrsDocumentPersistence;
    @BeanReference(type = LFTincanLrsEndpointPersistence.class)
    protected LFTincanLrsEndpointPersistence lfTincanLrsEndpointPersistence;
    @BeanReference(type = LFTincanLrsResultPersistence.class)
    protected LFTincanLrsResultPersistence lfTincanLrsResultPersistence;
    @BeanReference(type = LFTincanLrsStatePersistence.class)
    protected LFTincanLrsStatePersistence lfTincanLrsStatePersistence;
    @BeanReference(type = LFTincanLrsStatementPersistence.class)
    protected LFTincanLrsStatementPersistence lfTincanLrsStatementPersistence;
    @BeanReference(type = LFTincanLrsStatementRefPersistence.class)
    protected LFTincanLrsStatementRefPersistence lfTincanLrsStatementRefPersistence;
    @BeanReference(type = LFTincanLrsSubStatementPersistence.class)
    protected LFTincanLrsSubStatementPersistence lfTincanLrsSubStatementPersistence;
    @BeanReference(type = LFTincanManifestActivityPersistence.class)
    protected LFTincanManifestActivityPersistence lfTincanManifestActivityPersistence;
    @BeanReference(type = LFTincanPackagePersistence.class)
    protected LFTincanPackagePersistence lfTincanPackagePersistence;
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the l f objective in the entity cache if it is enabled.
     *
     * @param lfObjective the l f objective
     */
    public void cacheResult(LFObjective lfObjective) {
        EntityCacheUtil.putResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveImpl.class, lfObjective.getPrimaryKey(), lfObjective);

        lfObjective.resetOriginalValues();
    }

    /**
     * Caches the l f objectives in the entity cache if it is enabled.
     *
     * @param lfObjectives the l f objectives
     */
    public void cacheResult(List<LFObjective> lfObjectives) {
        for (LFObjective lfObjective : lfObjectives) {
            if (EntityCacheUtil.getResult(
                        LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
                        LFObjectiveImpl.class, lfObjective.getPrimaryKey()) == null) {
                cacheResult(lfObjective);
            } else {
                lfObjective.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f objectives.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFObjectiveImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFObjectiveImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f objective.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFObjective lfObjective) {
        EntityCacheUtil.removeResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveImpl.class, lfObjective.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFObjective> lfObjectives) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFObjective lfObjective : lfObjectives) {
            EntityCacheUtil.removeResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
                LFObjectiveImpl.class, lfObjective.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f objective with the primary key. Does not add the l f objective to the database.
     *
     * @param lfId the primary key for the new l f objective
     * @return the new l f objective
     */
    public LFObjective create(long lfId) {
        LFObjective lfObjective = new LFObjectiveImpl();

        lfObjective.setNew(true);
        lfObjective.setPrimaryKey(lfId);

        return lfObjective;
    }

    /**
     * Removes the l f objective with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfId the primary key of the l f objective
     * @return the l f objective that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective remove(long lfId)
        throws NoSuchLFObjectiveException, SystemException {
        return remove(Long.valueOf(lfId));
    }

    /**
     * Removes the l f objective with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f objective
     * @return the l f objective that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective remove(Serializable primaryKey)
        throws NoSuchLFObjectiveException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFObjective lfObjective = (LFObjective) session.get(LFObjectiveImpl.class,
                    primaryKey);

            if (lfObjective == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFObjectiveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfObjective);
        } catch (NoSuchLFObjectiveException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFObjective removeImpl(LFObjective lfObjective)
        throws SystemException {
        lfObjective = toUnwrappedModel(lfObjective);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfObjective);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfObjective);

        return lfObjective;
    }

    @Override
    public LFObjective updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective,
        boolean merge) throws SystemException {
        lfObjective = toUnwrappedModel(lfObjective);

        boolean isNew = lfObjective.isNew();

        LFObjectiveModelImpl lfObjectiveModelImpl = (LFObjectiveModelImpl) lfObjective;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfObjective, merge);

            lfObjective.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFObjectiveModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfObjectiveModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfObjectiveModelImpl.getOriginalSequencingID(),
                        /* Boolean.valueOf(   */
                        lfObjectiveModelImpl.getOriginalIsPrimary()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfObjectiveModelImpl.getSequencingID(),
                        /* Boolean.valueOf( */
                        lfObjectiveModelImpl.getIsPrimary()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY,
                    args);
            }

            if ((lfObjectiveModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfObjectiveModelImpl.getOriginalSequencingID(),
                        /* Boolean.valueOf(   */
                        lfObjectiveModelImpl.getOriginalIsPrimary(),
                        
                        lfObjectiveModelImpl.getOriginalIdentifier()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfObjectiveModelImpl.getSequencingID(),
                        /* Boolean.valueOf( */
                        lfObjectiveModelImpl.getIsPrimary(),
                        
                        lfObjectiveModelImpl.getIdentifier()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveImpl.class, lfObjective.getPrimaryKey(), lfObjective);

        return lfObjective;
    }

    protected LFObjective toUnwrappedModel(LFObjective lfObjective) {
        if (lfObjective instanceof LFObjectiveImpl) {
            return lfObjective;
        }

        LFObjectiveImpl lfObjectiveImpl = new LFObjectiveImpl();

        lfObjectiveImpl.setNew(lfObjective.isNew());
        lfObjectiveImpl.setPrimaryKey(lfObjective.getPrimaryKey());

        lfObjectiveImpl.setLfId(lfObjective.getLfId());
        lfObjectiveImpl.setSequencingID(lfObjective.getSequencingID());
        lfObjectiveImpl.setSatisfiedByMeasure(lfObjective.isSatisfiedByMeasure());
        lfObjectiveImpl.setIdentifier(lfObjective.getIdentifier());
        lfObjectiveImpl.setMinNormalizedMeasure(lfObjective.getMinNormalizedMeasure());
        lfObjectiveImpl.setIsPrimary(lfObjective.getIsPrimary());

        return lfObjectiveImpl;
    }

    /**
     * Returns the l f objective with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f objective
     * @return the l f objective
     * @throws com.liferay.portal.NoSuchModelException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f objective with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException} if it could not be found.
     *
     * @param lfId the primary key of the l f objective
     * @return the l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective findByPrimaryKey(long lfId)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchByPrimaryKey(lfId);

        if (lfObjective == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + lfId);
            }

            throw new NoSuchLFObjectiveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                lfId);
        }

        return lfObjective;
    }

    /**
     * Returns the l f objective with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f objective
     * @return the l f objective, or <code>null</code> if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjective fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f objective with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfId the primary key of the l f objective
     * @return the l f objective, or <code>null</code> if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective fetchByPrimaryKey(long lfId) throws SystemException {
        LFObjective lfObjective = (LFObjective) EntityCacheUtil.getResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
                LFObjectiveImpl.class, lfId);

        if (lfObjective == _nullLFObjective) {
            return null;
        }

        if (lfObjective == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfObjective = (LFObjective) session.get(LFObjectiveImpl.class,
                        Long.valueOf(lfId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfObjective != null) {
                    cacheResult(lfObjective);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFObjectiveModelImpl.ENTITY_CACHE_ENABLED,
                        LFObjectiveImpl.class, lfId, _nullLFObjective);
                }

                closeSession(session);
            }
        }

        return lfObjective;
    }

    /**
     * Returns all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @return the matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjective> findBySequencingIDAndIsPrimary(
        Integer sequencingID, Boolean isPrimary) throws SystemException {
        return findBySequencingIDAndIsPrimary(sequencingID, isPrimary,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @return the range of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjective> findBySequencingIDAndIsPrimary(
        Integer sequencingID, Boolean isPrimary, int start, int end)
        throws SystemException {
        return findBySequencingIDAndIsPrimary(sequencingID, isPrimary, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjective> findBySequencingIDAndIsPrimary(
        Integer sequencingID, Boolean isPrimary, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY;
            finderArgs = new Object[] { sequencingID, isPrimary };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARY;
            finderArgs = new Object[] {
                    sequencingID, isPrimary,
                    
                    start, end, orderByComparator
                };
        }

        List<LFObjective> list = (List<LFObjective>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFObjective lfObjective : list) {
                if (!Validator.equals(sequencingID,
                            lfObjective.getSequencingID()) ||
                        !Validator.equals(isPrimary, lfObjective.getIsPrimary())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LFOBJECTIVE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_2);
            }

            if (isPrimary == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (isPrimary != null) {
                    qPos.add(isPrimary.booleanValue());
                }

                list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective findBySequencingIDAndIsPrimary_First(
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchBySequencingIDAndIsPrimary_First(sequencingID,
                isPrimary, orderByComparator);

        if (lfObjective != null) {
            return lfObjective;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", isPrimary=");
        msg.append(isPrimary);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveException(msg.toString());
    }

    /**
     * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective, or <code>null</code> if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective fetchBySequencingIDAndIsPrimary_First(
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFObjective> list = findBySequencingIDAndIsPrimary(sequencingID,
                isPrimary, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective findBySequencingIDAndIsPrimary_Last(
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchBySequencingIDAndIsPrimary_Last(sequencingID,
                isPrimary, orderByComparator);

        if (lfObjective != null) {
            return lfObjective;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", isPrimary=");
        msg.append(isPrimary);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveException(msg.toString());
    }

    /**
     * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective, or <code>null</code> if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective fetchBySequencingIDAndIsPrimary_Last(
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingIDAndIsPrimary(sequencingID, isPrimary);

        List<LFObjective> list = findBySequencingIDAndIsPrimary(sequencingID,
                isPrimary, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f objectives before and after the current l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param lfId the primary key of the current l f objective
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective[] findBySequencingIDAndIsPrimary_PrevAndNext(long lfId,
        Integer sequencingID, Boolean isPrimary,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = findByPrimaryKey(lfId);

        Session session = null;

        try {
            session = openSession();

            LFObjective[] array = new LFObjectiveImpl[3];

            array[0] = getBySequencingIDAndIsPrimary_PrevAndNext(session,
                    lfObjective, sequencingID, isPrimary, orderByComparator,
                    true);

            array[1] = lfObjective;

            array[2] = getBySequencingIDAndIsPrimary_PrevAndNext(session,
                    lfObjective, sequencingID, isPrimary, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFObjective getBySequencingIDAndIsPrimary_PrevAndNext(
        Session session, LFObjective lfObjective, Integer sequencingID,
        Boolean isPrimary, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFOBJECTIVE_WHERE);

        if (sequencingID == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_2);
        }

        if (isPrimary == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sequencingID != null) {
            qPos.add(sequencingID.intValue());
        }

        if (isPrimary != null) {
            qPos.add(isPrimary.booleanValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfObjective);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFObjective> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @return the matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        Integer sequencingID, Boolean isPrimary, String identifier)
        throws SystemException {
        return findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
            isPrimary, identifier, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @return the range of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        Integer sequencingID, Boolean isPrimary, String identifier, int start,
        int end) throws SystemException {
        return findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
            isPrimary, identifier, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        Integer sequencingID, Boolean isPrimary, String identifier, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER;
            finderArgs = new Object[] { sequencingID, isPrimary, identifier };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER;
            finderArgs = new Object[] {
                    sequencingID, isPrimary, identifier,
                    
                    start, end, orderByComparator
                };
        }

        List<LFObjective> list = (List<LFObjective>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFObjective lfObjective : list) {
                if (!Validator.equals(sequencingID,
                            lfObjective.getSequencingID()) ||
                        !Validator.equals(isPrimary, lfObjective.getIsPrimary()) ||
                        !Validator.equals(identifier,
                            lfObjective.getIdentifier())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_LFOBJECTIVE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_SEQUENCINGID_2);
            }

            if (isPrimary == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_ISPRIMARY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_ISPRIMARY_2);
            }

            if (identifier == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_1);
            } else {
                if (identifier.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_3);
                } else {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (isPrimary != null) {
                    qPos.add(isPrimary.booleanValue());
                }

                if (identifier != null) {
                    qPos.add(identifier);
                }

                list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective findBySequencingIDAndIsPrimaryAndIdentifier_First(
        Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchBySequencingIDAndIsPrimaryAndIdentifier_First(sequencingID,
                isPrimary, identifier, orderByComparator);

        if (lfObjective != null) {
            return lfObjective;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", isPrimary=");
        msg.append(isPrimary);

        msg.append(", identifier=");
        msg.append(identifier);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveException(msg.toString());
    }

    /**
     * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective, or <code>null</code> if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective fetchBySequencingIDAndIsPrimaryAndIdentifier_First(
        Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFObjective> list = findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
                isPrimary, identifier, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective findBySequencingIDAndIsPrimaryAndIdentifier_Last(
        Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = fetchBySequencingIDAndIsPrimaryAndIdentifier_Last(sequencingID,
                isPrimary, identifier, orderByComparator);

        if (lfObjective != null) {
            return lfObjective;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(", isPrimary=");
        msg.append(isPrimary);

        msg.append(", identifier=");
        msg.append(identifier);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveException(msg.toString());
    }

    /**
     * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective, or <code>null</code> if a matching l f objective could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective fetchBySequencingIDAndIsPrimaryAndIdentifier_Last(
        Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
                isPrimary, identifier);

        List<LFObjective> list = findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
                isPrimary, identifier, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f objectives before and after the current l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param lfId the primary key of the current l f objective
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f objective
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjective[] findBySequencingIDAndIsPrimaryAndIdentifier_PrevAndNext(
        long lfId, Integer sequencingID, Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveException, SystemException {
        LFObjective lfObjective = findByPrimaryKey(lfId);

        Session session = null;

        try {
            session = openSession();

            LFObjective[] array = new LFObjectiveImpl[3];

            array[0] = getBySequencingIDAndIsPrimaryAndIdentifier_PrevAndNext(session,
                    lfObjective, sequencingID, isPrimary, identifier,
                    orderByComparator, true);

            array[1] = lfObjective;

            array[2] = getBySequencingIDAndIsPrimaryAndIdentifier_PrevAndNext(session,
                    lfObjective, sequencingID, isPrimary, identifier,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFObjective getBySequencingIDAndIsPrimaryAndIdentifier_PrevAndNext(
        Session session, LFObjective lfObjective, Integer sequencingID,
        Boolean isPrimary, String identifier,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFOBJECTIVE_WHERE);

        if (sequencingID == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_SEQUENCINGID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_SEQUENCINGID_2);
        }

        if (isPrimary == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_ISPRIMARY_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_ISPRIMARY_2);
        }

        if (identifier == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_1);
        } else {
            if (identifier.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_3);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_2);
            }
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sequencingID != null) {
            qPos.add(sequencingID.intValue());
        }

        if (isPrimary != null) {
            qPos.add(isPrimary.booleanValue());
        }

        if (identifier != null) {
            qPos.add(identifier);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfObjective);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFObjective> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f objectives.
     *
     * @return the l f objectives
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjective> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objectives.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @return the range of l f objectives
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjective> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f objectives.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f objectives
     * @param end the upper bound of the range of l f objectives (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f objectives
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjective> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<LFObjective> list = (List<LFObjective>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFOBJECTIVE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFOBJECTIVE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFObjective>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f objectives where sequencingID = &#63; and isPrimary = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @throws SystemException if a system exception occurred
     */
    public void removeBySequencingIDAndIsPrimary(Integer sequencingID,
        Boolean isPrimary) throws SystemException {
        for (LFObjective lfObjective : findBySequencingIDAndIsPrimary(
                sequencingID, isPrimary)) {
            remove(lfObjective);
        }
    }

    /**
     * Removes all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @throws SystemException if a system exception occurred
     */
    public void removeBySequencingIDAndIsPrimaryAndIdentifier(
        Integer sequencingID, Boolean isPrimary, String identifier)
        throws SystemException {
        for (LFObjective lfObjective : findBySequencingIDAndIsPrimaryAndIdentifier(
                sequencingID, isPrimary, identifier)) {
            remove(lfObjective);
        }
    }

    /**
     * Removes all the l f objectives from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFObjective lfObjective : findAll()) {
            remove(lfObjective);
        }
    }

    /**
     * Returns the number of l f objectives where sequencingID = &#63; and isPrimary = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @return the number of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    public int countBySequencingIDAndIsPrimary(Integer sequencingID,
        Boolean isPrimary) throws SystemException {
        Object[] finderArgs = new Object[] { sequencingID, isPrimary };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARY,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFOBJECTIVE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_SEQUENCINGID_2);
            }

            if (isPrimary == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARY_ISPRIMARY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (isPrimary != null) {
                    qPos.add(isPrimary.booleanValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARY,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param isPrimary the is primary
     * @param identifier the identifier
     * @return the number of matching l f objectives
     * @throws SystemException if a system exception occurred
     */
    public int countBySequencingIDAndIsPrimaryAndIdentifier(
        Integer sequencingID, Boolean isPrimary, String identifier)
        throws SystemException {
        Object[] finderArgs = new Object[] { sequencingID, isPrimary, identifier };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFOBJECTIVE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_SEQUENCINGID_2);
            }

            if (isPrimary == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_ISPRIMARY_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_ISPRIMARY_2);
            }

            if (identifier == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_1);
            } else {
                if (identifier.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_3);
                } else {
                    query.append(_FINDER_COLUMN_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER_IDENTIFIER_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (isPrimary != null) {
                    qPos.add(isPrimary.booleanValue());
                }

                if (identifier != null) {
                    qPos.add(identifier);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEQUENCINGIDANDISPRIMARYANDIDENTIFIER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f objectives.
     *
     * @return the number of l f objectives
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFOBJECTIVE);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the l f objective persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFObjective")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFObjective>> listenersList = new ArrayList<ModelListener<LFObjective>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFObjective>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFObjectiveImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
