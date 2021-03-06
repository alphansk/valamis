/**
 * Created by aklimov on 13.08.15.
 */

lessonStudio.module("Views", function (Views, lessonStudio, Backbone, Marionette, $, _) {

    var SEARCH_TIMEOUT = 800;

    var DISPLAY_TYPE = {
        LIST: 'list',
        TILES: 'tiles'
    };

    Views.BaseLessonInfoView = Marionette.ItemView.extend({
        template: '#lessonStudioEditItemView',
        templateHelpers: function () {
            return {
                'courseId': Utils.getCourseId()
            }
        },
        modelEvents: {
            'change:logo': 'onModelChanged',
            'change:logoSrc': 'onModelLogoChanged'
        },
        behaviors: {
            ValamisUIControls: {},
            ImageUpload: {
                'postponeLoading': true,
                'getFolderId': function(model){
                    return 'slideset_logo_' + model.get('id');
                },
                'getFileUploaderUrl': function (model) {
                    return path.root + path.api.files + 'slideset/' + model.get('id') + '/logo';
                },
                'uploadLogoMessage' : function() { return Valamis.language['uploadLogoMessage'];},
                'fileUploadModalHeader' : function() { return Valamis.language['fileUploadModalHeader']; }
            }
        },
        onShow: function() {
            this.$('.js-lesson-title').focus();
        },
        onValamisControlsInit: function () {
            var that = this;
            this.tags = new Valamis.TagCollection();
            this.tags.on('reset', function (tags) {
                that.fillTagSelect(tags);
            });

            this.tags.fetch({reset: true});
        },
        saveModelsTextValues: function () {
            var title = this.$('.js-lesson-title').val().trim() || Valamis.language['defaultLessonTitleLabel'];
            var description = this.$('.js-lesson-description').val();

            var tagsElem = this.$('.val-tags')[0].selectize;
            var tagsIds = tagsElem.getValue().split(',');

            var tags = [], tagList = [];
            if(tagsIds[0] != '') {
                _.forEach(tagsIds, function (tagId) {
                    tagList.push(tagsElem.options[tagId].text);
                    tags.push({
                        id: tagId,
                        text: tagsElem.options[tagId].text
                    });
                });
            }

            this.model.set({
                title: title,
                description: description,
                courseId: Utils.getCourseId(),
                tags: tags,
                tagList: tagList.join(' • ')
            });
            if(this.$('#toggleTemplates').is(':checked'))
                this.model.set({
                    id: this.$('#template-selector').val(),
                    fromTemplate: true
                });
        },
        setupUI: function() {
            this.$('.js-lesson-title').val(this.model.get('title'));
            this.$('.js-lesson-description').val(this.model.get('description'));
        },
        onModelChanged: function () {
            this.saveModelsTextValues();
        },
        onModelLogoChanged: function () {
            this.$('.js-logo').attr('src', this.model.get('logoSrc'));
        },
        fillTagSelect: function (tags) {
            var selectTags = tags.map(function(model) {
                return {
                    id: model.get('id'),
                    text: model.get('text')
                }
            });

            var modelTags = _(this.model.get('tags')).map(function(tag) { return tag.id });

            var selectize = this.$('.js-lesson-tags').selectize({
                delimiter: ',',
                persist: false,
                valueField: 'id',
                options: selectTags,
                create: true
            });
            selectize[0].selectize.setValue(modelTags.value());
        }
    });

    Views.LessonCreateView = Views.BaseLessonInfoView.extend({
        events: {
            'change #template-selector': 'updateTemplateImage',
            'change #toggleTemplates': 'toggleTemplateDisplay',
            'click .template-info img': 'previewTemplate'
        },
        templateHelpers: function () {
            return {
                'templates': this.templates ? this.templates.toJSON() : []
            }
        },
        constructor: function(options) {
            this.events = _.extend({}, this.events, Views.BaseLessonInfoView.prototype.events);
            Views.BaseLessonInfoView.prototype.constructor.apply(this, arguments);
        },
        initialize: function (options) {
            this.constructor.__super__.initialize.apply(this, arguments);
            if(options.templates)
                this.templates = new lessonStudio.Entities.LessonCollection(_.filter(options.templates.models, function(template) {
                    return template.get('courseId') > 0;
                }));
        },
        onRender: function(){
            this.setupUI();
        },
        updateTemplateImage: function() {
            this.lessonTemplate = this.templates.get(this.$('#template-selector').val());

            var src = this.lessonTemplate.get('logo')
                ? path.root + path.api.files + 'images?folderId=slideset_logo_'
                    + this.$('#template-selector').val()
                    + '&file=' + this.lessonTemplate.get('logo')
                : path.root + path.portlet.prefix + 'img/imgo.jpg';
            this.$('.template-info img').attr('src', src);
            this.$('.template-info label.js-template-label').html(this.lessonTemplate.get('slides').length + ' elements');
        },
        toggleTemplateDisplay: function() {
            this.$('.checkbox-label').parent().nextAll().toggleClass('hidden');
        },
        previewTemplate: function() {
            this.triggerMethod('template:preview', this.lessonTemplate);
        }
    });

    Views.LessonEditInfoView = Views.BaseLessonInfoView.extend({
        onRender: function(){
            this.setupUI();
            this.$('.js-template-row').css('display', 'none');
        }
    });

    Views.ToolbarView = Marionette.ItemView.extend({
        template: '#lessonStudioToolbarTemplate',
        events: {
            'click .dropdown-menu > li.js-sort': 'changeSort',
            'keyup .js-search': 'changeSearchText',
            'click .js-list-view': 'listDisplayMode',
            'click .js-tile-view': 'tilesDisplayMode',
            'click .js-create-lesson': 'createLesson'
        },
        triggers: {
            "click .js-package-upload": "toolbar:upload:lesson"
        },
        behaviors: {
            ValamisUIControls: {}
        },
        initialize: function(){},
        onValamisControlsInit: function(){
            this.$('.js-sort-filter').valamisDropDown('select', this.model.get('sort'));
            this.$('.js-search').val(this.model.get('searchtext'));

            var displayMode = lessonStudio.settings.get('displayMode');
            if (displayMode === DISPLAY_TYPE.TILES)
                this.$('.js-tile-view').addClass('active');
            else
                this.$('.js-list-view').addClass('active');
        },
        onShow: function(){},
        changeSort: function(e){
            this.model.set('sort', $(e.target).attr("data-value"));
        },
        changeSearchText:function(e){
            var that = this;
            clearTimeout(this.inputTimeout);
            this.inputTimeout = setTimeout(function(){
                that.model.set('searchtext', $(e.target).val());
            }, SEARCH_TIMEOUT);
        },
        listDisplayMode: function(){
            this.changeDisplayMode('list');
            this.$('.js-list-view').addClass('active');
        },
        tilesDisplayMode: function(){
            this.changeDisplayMode('tiles');
            this.$('.js-tile-view').addClass('active');
        },
        changeDisplayMode: function(displayMode){
            this.triggerMethod('toolbar:displaymode:change', displayMode);
            this.$('.js-display-option').removeClass('active');
        },
        createLesson: function(){
            this.triggerMethod('toolbar:lesson:new');
        }
    });

    Views.LessonItemView = Marionette.ItemView.extend({
        template: '#lessonStudioItemView',
        templateHelpers: function () {
            return {
                'courseId': Utils.getCourseId,
                'slidesCount': this.model.get('slidesCount'),
                'timestamp': Date.now(),
                'formattedVersion': parseFloat(this.model.get('version')).toFixed(1)
            }
        },
        className: 'tile s-12 m-4 l-2',
        events: {
            'click .dropdown-menu > li.js-lesson-edit': 'editLesson',
            'click .dropdown-menu > li.js-lesson-compose': 'composeLesson',
            'click .dropdown-menu > li.js-lesson-delete': 'deleteLesson',
            'click .dropdown-menu > li.js-lesson-publish': 'publishLesson',
            'click .dropdown-menu > li.js-lesson-export': 'exportLesson',
            'click .dropdown-menu > li.js-lesson-clone': 'cloneLesson',
            'click .dropdown-menu > li.js-lesson-save-template': 'saveLessonTemplate',
            'click .js-lesson-image': 'composeLesson'
        },
        behaviors: {
            ValamisUIControls: {}
        },
        /* set the template used to display this view */
        modelEvents: {
          'lesson:saved': 'render',
          'change:status': 'render'
        },
        /* used to show the order in which these method are called */
        initialize: function(options){},
        onRender: function(){
        },
        onShow: function(){},
        editLesson: function(){
            this.triggerMethod('lessonList:edit:lesson', this.model);
        },
        composeLesson: function(){
            this.triggerMethod('lessonList:compose:lesson', this.model);
        },
        deleteLesson: function(){
            var that = this;
            valamisApp.execute('delete:confirm', { message: Valamis.language['warningDeleteSlidesetMessageLabel'] }, function(){
                that.deleteLess();
            });
        },
        deleteLess: function () {
            this.triggerMethod('lessonList:delete:lesson', this.model);
        },
        exportLesson: function(){
            window.location = path.root + path.api.files + 'export/?action=EXPORT&contentType=SLIDE_SET' +
            '&id=' + this.model.id +
            '&courseId=' + Utils.getCourseId();
        },
        publishLesson: function() {
            this.triggerMethod('lessonList:publish:lesson', this.model);
        },
        cloneLesson: function() {
            this.triggerMethod('lessonList:clone:lesson', this.model);
        },
        saveLessonTemplate: function() {
            this.triggerMethod('lessonList:saveTemplate:lesson', this.model);
        }
    });

    // TODO create PagedCollectionView
    Views.Lessons = Marionette.CollectionView.extend({
        className: 'js-lesson-items val-row',
        template: "#lessonStudioLessonList",
        childView: Views.LessonItemView,
        initialize: function (options) {
            this.paginatorModel = options.paginatorModel;
        },
        onRender: function() {
            var displayMode = lessonStudio.settings.get('displayMode') || DISPLAY_TYPE.LIST;
            this.$el.addClass(displayMode);
        },
        onShow: function(){},
        childEvents: {
            'lesson:edit':function(childView){
                this.triggerMethod('lessonList:edit:lesson', childView.model);
            },
            'lesson:compose':function(childView){
                this.triggerMethod('lessonList:compose:lesson', childView.model);
            }
        }
    });

    Views.publishLessonView = Marionette.ItemView.extend({
        template: '#lessonStudioSetVisibilityTemplate',
        templateHelpers: function() {
            return {
                isFirstVersion: this.options.isFirstVersion
            }
        },
        events: {
            'click .js-publish-lesson': 'publishLesson'
        },
        onShow: function() {
            var value = (this.options.isVisible == undefined) ? 'some' : this.options.isVisible;
            this.$('input[name="visibilitySettings"][value="'+ value +'"]').attr('checked', 'checked');
        },
        publishLesson: function() {
            var visibilityType = this.$('input[name="visibilitySettings"]:checked').val() || 'all';
            this.trigger('publish:lesson', visibilityType);
        }
    });

    Views.AppLayoutView = Marionette.LayoutView.extend({
        tagName: 'div',
        template: '#lessonStudioLayoutTemplate',
        regions:{
            'toolbar' : '#lessonStudioToolbar',
            'lessonList' : '#lessonStudioLessons',
            'paginator': '#lessonStudioPaginator',
            'paginatorShowing': '#lessonStudioToolbarShowing'
        },
        childEvents: {
            'toolbar:displaymode:change': function( childView, displayMode ) {
                this.lessonList.currentView.$el.removeClass('list');
                this.lessonList.currentView.$el.removeClass('tiles');
                this.lessonList.currentView.$el.addClass(displayMode);

                valamisApp.execute('update:tile:sizes', this.lessonList.currentView.$el);

                lessonStudio.settings.set('displayMode', displayMode);
                lessonStudio.settings.save();
            },
            'toolbar:lesson:new': function(childView){
                var newLesson = new lessonStudio.Entities.LessonModel();
                var createView = new Views.LessonCreateView({ model: newLesson, templates: lessonStudio.lessonTemplates });
                var createModalView = new valamisApp.Views.ModalView({
                    contentView: createView,
                    header: Valamis.language['newLessonLabel'],
                    submit: function(){
                        createView.saveModelsTextValues();

                        newLesson.saveFunc = newLesson.get('fromTemplate') ? newLesson.clone : newLesson.save;
                        newLesson.saveFunc().then(function() {
                            createView.trigger('view:submit:image', function(name){
                                valamisApp.execute('modal:close', createModalView);
                                lessonStudio.execute('lessons:reload');
                                valamisApp.execute('notify', 'success', Valamis.language['lessonWasCreatedSuccessfullyLabel']);
                            });
                        });
                    }
                });

                valamisApp.execute('modal:show', createModalView);

                createView.on('template:preview', function (model) {
                    childView.triggerMethod('lessonList:compose:lesson', model);

                });
            },
            'lessonList:edit:lesson': function(childView, model){
                var editView = new Views.LessonEditInfoView({ model: model });
                var editModalView = new valamisApp.Views.ModalView({
                    contentView: editView,
                    header: Valamis.language['editLessonInfoLabel'],
                    submit: function(){
                        editView.saveModelsTextValues();

                        model.save().then(function() {
                            editView.trigger('view:submit:image', function(){
                                childView.render();
                                valamisApp.execute('modal:close', editModalView);
                            });
                        });
                    }
                });

                valamisApp.execute('modal:show', editModalView);
            },
            'lessonList:compose:lesson': function(childView, model){
                var func_onShown = function(){
                    if( !slidesApp.initialized ){
                        slidesApp.start();
                    }
                    slidesApp.isEditorReady = true;
                    slidesApp.toggleSavedState(true);
                    jQueryValamis('.slideset-editor').toggleClass('hidden',false);

                    slidesApp.initializing = true;
                    slidesApp.isUndoAction = false;
                    slidesApp.slideRegistry.items = {};
                    slidesApp.selectedItemView = null;
                    showSlideSet(new lessonStudio.Entities.LessonModel(model.toJSON()));
                };
                valamisApp.execute('portlet:set:onbeforeunload', Valamis.language['loseUnsavedWorkLabel'], function(){
                    //Confirm only if not saved
                    return !slidesApp.historyManager.isSaved();
                });
                valamisApp.execute('notify', 'info', Valamis.language['lessonIsLoadingLabel'], {
                    'timeOut': '0',
                    'extendedTimeOut': '0',
                    'onShown': func_onShown
                });
            },
            'lessonList:publish:lesson': function(childView, model){
                var that = this;
                model.getLessonId().then(
                  function (lesson) {
                      var lessonId = lesson.id;
                      var isFirstVersion = model.get('version') === 1;

                      var publishLessonView = new Views.publishLessonView({
                          isVisible: lesson.isVisible,
                          isFirstVersion: isFirstVersion
                      });
                      var modalView = new valamisApp.Views.ModalView({
                          contentView: publishLessonView,
                          className: 'lesson-studio-modal select-display-format-modal',
                          header: Valamis.language['publishLessonLabel'],
                          beforeCancel: function() {
                              // remove prepared package entity if user close publishing first version draft
                              if (isFirstVersion && model.get('status') == 'draft')
                                model.deleteUnpublishedLesson({}, { lessonId: lessonId });
                          }
                      });
                      publishLessonView.on('publish:lesson', function (visibilityType) {
                          valamisApp.execute('modal:close', modalView);
                          var isCustom = visibilityType === 'some';
                          that.publishLesson(model);

                          var isVisible = (isCustom) ? 'null' : (visibilityType);
                          model.updateLessonVisibility({}, {
                              lessonId: lessonId,
                              isVisible: isVisible
                          });

                          if (isCustom) {
                              var editVisibilityView = new valamisApp.Views.EditVisibility.EditVisibilityView({
                                  packageId: lessonId
                              });
                              var editVisibilityModalView = new valamisApp.Views.ModalView({
                                  contentView: editVisibilityView,
                                  header: Valamis.language['editVisibilitySettingsLabel']
                              });
                              valamisApp.execute('modal:show', editVisibilityModalView);
                          }
                      });
                      valamisApp.execute('modal:show', modalView);
                  },
                  function () {
                      valamisApp.execute('notify', 'error', Valamis.language['lessonFailedToPublishLabel']);
                  }
                );
            },
            'lessonList:clone:lesson': function(childView, model){
                valamisApp.execute('notify', 'info', Valamis.language['processingLabel'], { 'timeOut': '0', 'extendedTimeOut': '0' });
                model.clone().then(function(){
                    valamisApp.execute('notify', 'clear');
                    valamisApp.execute('notify', 'success', Valamis.language['lessonClonedLabel']);
                    lessonStudio.execute('lessons:reload');
                });
            },
            'lessonList:saveTemplate:lesson': function(childView, model){
                model.saveTemplate().then(
                    function() {
                        valamisApp.execute('notify', 'success', Valamis.language['lessonTemplateSavedLabel']);
                        lessonStudio.execute('lessons:reload');
                    },
                    function() {
                        valamisApp.execute('notify', 'error', Valamis.language['lessonTemplateSaveErrorLabel']);
                    }
                );
            },
            'lessonList:delete:lesson': function(childView, model){
                model.deleteAllVersions().then(
                    function() {
                        valamisApp.execute('notify', 'success', Valamis.language['lessonSuccessfullyDeletedLabel']);
                        lessonStudio.execute('lessons:reload');
                    },
                    function() {
                        valamisApp.execute('notify', 'error', Valamis.language['lessonFailedToDeleteLabel']);
                    }
                );
            }
        },
        initialize: function() {
            var that = this;
            that.paginatorModel = lessonStudio.paginatorModel;
            that.lessons = lessonStudio.lessons;

            that.lessons.on('lessonCollection:updated', function (details) {
                that.updatePagination(details);
            });
        },
        onRender: function() {
            var toolbarView = new Views.ToolbarView({
                model: lessonStudio.filter
            });

            var lessonListView = new Views.Lessons({
                collection: lessonStudio.lessons,
                paginatorModel: this.paginatorModel
            });

            this.toolbar.show(toolbarView);

            lessonListView.on('render:collection', function(view) {
                valamisApp.execute('update:tile:sizes', view.$el);
            });

            this.paginatorView = new ValamisPaginator({
                language: Valamis.language,
                model : this.paginatorModel
            });

            var paginatorShowingView = new ValamisPaginatorShowing({
                language: Valamis.language,
                model: this.paginatorModel
            });
            this.paginator.show(this.paginatorView);
            this.paginatorShowing.show(paginatorShowingView);

            this.paginatorView.on('pageChanged', function () {
                lessonStudio.execute('lessons:reload');
            }, this);

            this.lessonList.show(lessonListView);
            lessonStudio.execute('lessons:reload');
        },
        updatePagination: function (details, context) {
            this.paginatorView.updateItems(details.total);
        },
        publishLesson: function (model) {
            valamisApp.execute('notify', 'info', Valamis.language['processingLabel'], { 'timeOut': '0', 'extendedTimeOut': '0' });

            model.publish().then(
              function () {
                  model.set('status', 'published'); // todo: will not change if enumeration will be changed
                  valamisApp.execute('notify', 'clear');
                  valamisApp.execute('notify', 'success', Valamis.language['lessonPublishedLabel']);
              },
              function (data) {
                  valamisApp.execute('notify', 'clear');
                  var message = (data != "Failed Dependency") ? 'lessonFailedToPublishLabel' : 'lessonFailedToPublishNoQuestionLabel';
                  valamisApp.execute('notify', 'error', Valamis.language[message]);
              });

        },

        /* called when the view displays in the UI */
        onShow: function() {}
    });

    Views.DeviceItemView = Marionette.ItemView.extend({
        template: '#deviceItemTemplate',
        className: 'item',
        events: {
            'click .js-button-select': 'selectItem'
        },
        templateHelpers: function() {
            return {
                contextPath: path.root + path.portlet.prefix,
                title: Valamis.language[this.model.get('name')+'Label']
            }
        },
        onRender: function () {
            this.$el = this.$el.children();
            this.$el.unwrap();
            this.setElement( this.$el );
        },
        selectItem: function(e){
            e.preventDefault();
            var isSelected = this.$el.is('.active');
            var selected = this.$el.parent().find('li.active');
            if(isSelected && selected.size() == 1){
                return;
            }
            this.$el.toggleClass('active', !isSelected);
        }
    });


});