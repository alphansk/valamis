UPDATE Question SET
<#if categoryID??>
    categoryID = :categoryID,
</#if>
    title = :e.title,
    description = :e.text,
    explanationText = :e.explanationText,
<#if forceCorrectCount??>
    forceCorrectCount = :forceCorrectCount,
</#if>
<#if isCaseSensitive??>
    isCaseSensitive = :isCaseSensitive,
</#if>
    questionType = :e.questionTypeCode
WHERE id = :e.id