TranscriptUsersView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.render();
    },

    events: {
        'click #selectUserButton': 'openUserModal',
//        'click #printTranscriptButton': 'printTranscript'
        'click #printTranscriptButton' : 'clickPrintButton'
    },

    render: function () {
        var buttonModel = Backbone.Model.extend({});
        this.model = new buttonModel();
        this.model.set({companyID: jQuery('#transcriptCompanyID').val(), userID: jQuery('#transcriptUserID').val()});
        var template = Mustache.to_html(jQuery('#transcriptButtonsTemplate').html(), _.extend(this.model.toJSON(), this.language));
        this.$el.append(template);
    },

    openUserModal: function (e) {
        e.preventDefault();
        this.trigger('openSelectUserModal', this);
    },

    /*printTranscript: function () {
        var printModel = new PrintModel();
        printModel.fetch({
            data: {

            }*//*,
            success: (function () {
                alert(' Service request success: ');
            }),
            error: (function (e) {
                alert(' Service request failure: ' + e);
            }),
            complete: (function (e) {
                alert(' Service request completed ');
            })*//*
        });
    },*/

    clickPrintButton: function(e) {
//        e.preventDefault();
        jQuery('#printLink')[0].click();
        e.stopPropagation();
    }
});


TranscriptPackagesView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.render();
    },
    events: {
        'click #expandDetailsList': 'expandDetails'
    },
    render: function () {
        this.collection.each(this.addOne, this);
//        this.collection.each(this.addPackageDetails, this);
    },
    addOne: function (item) {
        var template = Mustache.to_html(
            jQuery('#transcriptPackageItemTemplate').html(),
            _.extend({
                    gradeAutoShowing: Utils.gradeToPercent(item.get('gradeAuto') || 0),
                    gradeShowing: Utils.gradeToPercent(item.get('grade'))
                },
                item.toJSON()));

        this.$el.append(template);
        this.addPackageDetails(item);
    },
    addPackageDetails: function (item) {
        var packageDetailsView = new TranscriptPackageDetailsView({model: item, language: this.language});
        this.$el.append(packageDetailsView.render().el);
    },
    expandDetails: function (e) {
      var elem = jQuery(e.currentTarget);
      var elemId = elem.data('package');
      this.$('#packageDetailsLayout-' + elemId).toggleClass('hidden');
      var isVisible = this.$('#packageDetailsLayout-' + elemId).is(':visible');
      elem.toggleClass('val-icon-plus', !isVisible);
      elem.toggleClass('val-icon-minus', isVisible);
    }
});


TranscriptPackageDetailsView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.collection = options.collection;
        this.packageModel = options.model;
        this.statements = JSON.parse(this.packageModel.get('statements')).statements;
        this.timeStarted = 0;
        this.timeFinished = 0;
        this.totalTime = 0;
        this.which = 1;

    },
    render: function () {
        if(this.statements.length == 0) {
            jQuery('#packageDetailsList-' + this.packageModel.id).closest('tr').prev().remove();
            jQuery('#packageDetailsList-' + this.packageModel.id).closest('tr').remove();
            return "";
        }

        var attemptStart = -1, attemptEnd = this.statements.length - 1;
        var allStatements = [];

        for(var i = this.statements.length - 1; i >= 0; i--) {
            if(this.statements[i].object.definition.type.substr(this.statements[i].object.definition.type.lastIndexOf("/") + 1, 6) == "course") {
                if(this.statements[i].verb.id == "http://adlnet.gov/expapi/verbs/attempted") {
                    var attemptStatements = [];
                    attemptStart = i;
                    if(attemptStart >= 0 && attemptEnd < this.statements.length) {
                        for (var j = attemptStart; j <= attemptEnd; j++) {
//                            if(this.statements[j].verb.id == "http://adlnet.gov/expapi/verbs/answered" || this.statements[j].verb.id == "http://adlnet.gov/expapi/verbs/experienced")
                                attemptStatements.push(this.statements[j]);
                        }
                        this.timeStarted = this.statements[i].stored.replace(/T/g, " ").replace(/Z/g, "").replace(/-/g, "/");
                        this.timeFinished = this.statements[attemptEnd].stored.replace(/T/g, " ").replace(/Z/g, "").replace(/-/g, "/");
                        this.totalTime += Math.abs(new Date(this.timeFinished) - new Date(this.timeStarted));
                    }

                    if(i > 0) {
                        if (this.statements[i - 1].verb.id == "http://adlnet.gov/expapi/verbs/completed" &&
                            this.statements[i - 1].object.definition.type.substr(this.statements[i - 1].object.definition.type.lastIndexOf("/") + 1, 6) == "course") {
                            attemptEnd = i - 1;
                        }
                        else {
                            attemptEnd = i;
                        }
                    }

                    var statements = new PackageStatementCollection();
                    statements.add(attemptStatements);
                    allStatements[this.which-1] = statements;
                    this.which++;
                }
            }
        }

        this.days = Math.floor(this.totalTime/(1000*60*60*24));
        this.hours = Math.floor(this.totalTime/(1000*60*60));
        this.minutes = Math.floor(this.totalTime/(1000*60));
        this.seconds = Math.floor(this.totalTime/(1000));
        this.totalTime = (this.days > 0 ? this.days + (((this.days) % 10 == 1 && this.days % 100 != 11) ? " day, " : " days, ") : "")
            + (this.hours > 0 ? (this.hours - this.days*24) + (((this.hours) % 10 == 1 && this.hours % 100 != 11) ? " hour, " : " hours, ") : "")
            + (this.minutes > 0 ? (this.minutes - this.hours*60) + (((this.minutes) % 10 == 1 && this.minutes % 100 != 11) ? " minute, " : " minutes, ") : "")
            + (this.seconds > 0 ? (this.seconds - this.minutes*60) + (((this.seconds) % 10 == 1 && this.seconds % 100 != 11) ? " second." : " seconds.") : "");

        this.model.set({packageId: this.packageModel.id, statementCount: this.statements.length, totalTime: this.totalTime});
        var template = Mustache.to_html(jQuery('#transcriptPackageDetailsTemplate').html(), _.extend(this.model.toJSON()));
        jQuery('#packageDetailsList-' + this.packageModel.id).html(template);
//        jQuery('#packageDetailsList-' + this.packageModel.id).toggleClass('hidden');


        for(var i = 0; i < allStatements.length ; i++) {
            this.which = allStatements.length - i;
            var statementAttemptView = new TranscriptPackageAttemptStatementsView({model: new TranscriptModel(), which: this.which, packageId: this.packageModel.id});
            jQuery('#package-' + this.packageModel.id + '-statements').append(statementAttemptView.render().el);
            allStatements[i].each(this.addPackageStatements, this);
        }

        return this;
    },

    addPackageStatements: function(item) {
        var view = new TranscriptPackageStatementItemView({model: item, which: this.which, language: this.language});
        jQuery('#package-' + this.packageModel.id + '-attempt-' + this.which + '-statements').append(view.render().el);
    }
});

TranscriptPackageStatementItemView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.verb = this.language[options.model.get('verb').id].toLowerCase();
        this.object = options.model.get('object').definition.name[Object.keys(options.model.get('object').definition.name)[0]];
        if(options.model.get('result') !== undefined && this.verb == 'answered' && options.model.get('result').response !== undefined) {
            this.answer = options.model.get('result').response || '';
            this.answer = this.answer.replace(/\[\.\]/g, '->').replace(/[\[\]]/g, '').replace(/,/g, ', ');
            if(options.model.get('result').score !== undefined) {
                this.score = options.model.get('result').score.scaled;
                this.model.set({score: this.score});
            }
            this.model.set({answer: this.answer});
        }

        var storedTime = new Date(options.model.get('stored'));

        this.storedTime = storedTime.toLocaleDateString() + " " + storedTime.toLocaleTimeString();
        this.which = options.which;
        this.model.set({verb: this.verb, object: this.object, storedTime: this.storedTime, which: this.which});
    },

    tagName: 'tr',

    render: function () {
        var template = Mustache.to_html(jQuery('#transcriptPackageStatementItemTemplate').html(), _.extend(this.model.toJSON(), this.language));
        this.$el.append(template);
        this.$el.css({
            'style': 'border-right: none;'
        });

        return this;
    }
});

TranscriptPackageAttemptStatementsView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.which = options.which;
        this.packageId = options.packageId;
        this.model.set({which: this.which, packageId: this.packageId});
    },

    tagName: 'tr',

    events: {
        'click .js-expand-attempt': 'expandPackageAttemptStatements'
    },

    render: function () {
        var template = Mustache.to_html(jQuery('#transcriptPackageAttemptStatementsTemplate').html(), _.extend(this.model.toJSON(), this.language));
        this.$el.append(template);

        return this;
    },

    expandPackageAttemptStatements: function (e) {
        var elem = jQuery(arguments[0].target).parent().find('#package-' + this.packageId + '-attempt-' + this.which + '-statements');
        elem.toggleClass('hidden');
        var isVisible = elem.is(':visible');
        jQuery(e.currentTarget).toggleClass('val-icon-plus', !isVisible);
        jQuery(e.currentTarget).toggleClass('val-icon-minus', isVisible);
    }
});

// ####

TranscriptCoursesItemView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
    },
    className: 'clearfix',
    events: {
        'click #expandPackageList': 'expandPackages'
    },
    render: function () {
        var template = Mustache.to_html(jQuery('#transcriptCoursesItemTemplate').html(), _.extend(this.model.toJSON(), this.language));
        this.$el.html(template);

        /*if (this.model.packages == undefined) {*/
            var packages = new PackagesCollection();
            var that = this;
            packages.on('packageCollection:updated', function(grade) {
                that.$('#expandPackageTitle').append(" - " + that.language['gradeLabel'] + " " + Utils.gradeToPercent(grade.totalGrade) +"%");
            });

            packages.fetch({courseId: this.model.id, success: function () {
                new TranscriptPackagesView({el: that.$el.find('#packagesList-'+that.model.id+'>tbody'), collection: packages, language: that.language});
                that.model.packages = packages;
            }});
        /*}*/
        return this;
    },
    expandPackages: function (e) {
      var elem = jQuery(e.currentTarget);
      var elemId = elem.data('course');
      this.$('#packagesList-' + elemId).toggleClass('hidden');
      var isVisible = this.$('#packagesList-' + elemId).is(':visible');
      elem.toggleClass('val-icon-plus', !isVisible);
      elem.toggleClass('val-icon-minus', isVisible);
    }
});

TranscriptCoursesView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.render();
    },

    render: function () {
        var template = Mustache.to_html(jQuery('#transcriptCoursesTemplate').html(), _.extend(this.language));
        this.$el.append(template);
        this.collection.each(this.addOne, this);
    },

    addOne: function (item) {
        var view = new TranscriptCoursesItemView({language: this.language, model: item});
        this.$el.find('#coursesList').append(view.render().el);
    }
});

// ####

TranscriptCertificatesItemView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
    this.model = options.model;
  },

  render: function () {
    var statements = new StatementModelCollection({amount: 0});

    var certificates = new CertificateGoalCollection({certificateID: this.model.id});
//    certificates.fetch({certificateID: this.model.id});
    var statuses = new CertificateGoalStatus({certificateID: this.model.id});

    var that = this;

    certificates.fetch({certificateID: this.model.id, language: this.language,
      success: function(){
          statuses.fetch({reset: true, certificateID: that.model.id, userID: jQuery('#transcriptUserID').val(),
              success: function() {
                  var datesFinish = [];
                  var activities = statuses.get('activities') !== undefined ? statuses.get('activities') : [];
                  var courses = statuses.get('courses') !== undefined ? statuses.get('courses') : [];
                  var stmnts = statuses.get('statements') !== undefined ? statuses.get('statements') : [];
                  var packages = statuses.get('packages') !== undefined ? statuses.get('packages') : [];

                  // Only if the certificate has goals
                  if(activities.length > 0 || courses.length > 0 || stmnts.length > 0 || packages.length > 0) {
                      for (var i = 0; i < activities.length; i++) {
                          var item = new CertificateGoalStatus(activities[i]);
                          if (!item.get('dateFinish')){
                          datesFinish.push([item.get('dateFinish').slice(0, item.get('dateFinish').lastIndexOf("/") + 1), "20", item.get('dateFinish').slice(item.get('dateFinish').lastIndexOf("/") + 1)].join(""));}
                      }
                      for (var i = 0; i < courses.length; i++) {
                          var item = new CertificateGoalStatus(courses[i]);
                          if (!item.get('dateFinish')){
                          datesFinish.push([item.get('dateFinish').slice(0, item.get('dateFinish').lastIndexOf("/") + 1), "20", item.get('dateFinish').slice(item.get('dateFinish').lastIndexOf("/") + 1)].join(""));}
                      }
                      for (var i = 0; i < stmnts.length; i++) {
                          var item = new CertificateGoalStatus(stmnts[i]);
                          if (!item.get('dateFinish')){
                          datesFinish.push([item.get('dateFinish').slice(0, item.get('dateFinish').lastIndexOf("/") + 1), "20", item.get('dateFinish').slice(item.get('dateFinish').lastIndexOf("/") + 1)].join(""));}
                      }
                      for (var i = 0; i < packages.length; i++) {
                          var item = new CertificateGoalStatus(packages[i]);
                          if (!item.get('dateFinish')){
                          datesFinish.push([item.get('dateFinish').slice(0, item.get('dateFinish').lastIndexOf("/") + 1), "20", item.get('dateFinish').slice(item.get('dateFinish').lastIndexOf("/") + 1)].join(""));}
                      }

                      datesFinish.sort(function (a, b) {
                          return new Date(b) - new Date(a);
                      });

                      var issueDate = new Date(datesFinish[0]);
                  }
                  else {
                      var issueDate = new Date(Object.keys(certificates.models[0].get('users'))[0]);
                  }

                  if(issueDate != "") {
                      var validPeriodType = certificates.models[0].get('periodType');

                      var validDuration = certificates.models[0].get('periodValue');
                      if (validPeriodType.toLowerCase() != 'unlimited') {
                          var expirationDate = that.dateAdd(issueDate, validPeriodType, validDuration);
                          expirationDate = that.dateFormat(expirationDate);
                          that.model.set({expires: true, expirationDate: expirationDate});
                      }

                      issueDate = that.dateFormat(issueDate);
                  }
                  else {
                      that.model.set({expires: true, expirationDate: ""});
                  }

                  that.model.set({issueDate: issueDate});

                  var template = Mustache.to_html(jQuery('#transcriptCertificatesItemTemplate').html(), _.extend(that.model.toJSON(), that.language));
                  that.$el.append(template);

                  statements.fetch({
                      success: function() {
                          var goalView = new TranscriptCertificateGoalView({
                              certificates: certificates, statuses: statuses, statements: statements, certificateID: that.model.id, language: scormLanguageDataUser});
                          that.$el.find('#certificate-goal-list-' + that.model.id).append(goalView.render().el.innerHTML);
                      }
                  });
              }
          });
      }
    });

    return this;
  },

  dateAdd :function(date, interval, units) {
    var ret = new Date(date);
    switch(interval.toLowerCase()) {
        case 'year'      :  ret.setFullYear(ret.getFullYear() + units);  break;
        case 'quarter'   :  ret.setMonth(ret.getMonth() + 3*units);  break;
        case 'month'     :  ret.setMonth(ret.getMonth() + units);  break;
        case 'weeks'     :  ret.setDate(ret.getDate() + 7*units);  break;
        case 'days'      :  ret.setDate(ret.getDate() + units);  break;
        case 'hours'     :  ret.setTime(ret.getTime() + units*3600000);  break;
        case 'minutes'   :  ret.setTime(ret.getTime() + units*60000);  break;
        case 'seconds'   :  ret.setTime(ret.getTime() + units*1000);  break;
        case 'unlimited' :  ret = ""; break;
        default          :  ret = undefined;  break;
    }
    return ret;
  },

  dateFormat: function(date) {
      return (date.getDate() < 10 ? "0" : "") + date.getDate() + "/"
           + (date.getMonth() + 1) + "/"
           + date.getFullYear() + " "
           + (date.getHours() < 10 ? "0" : "") + date.getHours() + ":"
           + (date.getMinutes() < 10 ? "0" : "") + date.getMinutes();
  }
});


TranscriptCertificatesView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
    this.render();
  },
  events: {
      'click #expandGoalsList': 'expandGoals'
  },

  render: function () {
    var template = Mustache.to_html(jQuery('#transcriptCertificatesTemplate').html(), _.extend(this.language));

    this.$el.append(template);
    this.collection.each(this.addOne, this);
  },

  addOne: function (item) {
    if (item.get('status') == 'Success' || item.get('status') == 'Overdue') {
        var view = new TranscriptCertificatesItemView({el: this.$el.find('#certificatesList>tbody'), language: this.language, model: item});
        this.$el.find('#certificatesList>tbody').append(view.render().el);

        item.get()
    }
  },
    expandGoals: function (e) {
      var elem = jQuery(e.currentTarget);
      var elemId = elem.data('certificate');
      this.$('#certificateGoalsLayout-' + elemId).toggleClass('hidden');
      var isVisible = this.$('#certificateGoalsLayout-' + elemId).is(':visible');
      elem.toggleClass('val-icon-plus', !isVisible);
      elem.toggleClass('val-icon-minus', isVisible);
    }
});

GoalStatusView = Backbone.View.extend({
    tagName: 'tr',
    initialize: function (options) {
        this.language = options.language;
        this.statements = options.statements;
        this.model = options.model;
        this.model.set({
            type: options.type,
            certificateID: options.certificateID,
            status: options.status,
            dateFinish: options.dateFinish,
            title: options.title
        });

        var obj = this.model.get('obj');
        var verb = this.model.get('verb');

        if (options.type == GOAL_TYPE.STATEMENT) {
            this.statements.each(function(stmnt){
                for(var key in stmnt.get('object').definition.name) {
                    if(stmnt.get('object').id == obj) {
                        obj = stmnt.get('object').definition.name[key];
                    }
                }
            });

            var objectName = this.model.get('objName');
            var objectTitle = objectName ? Utils.getLangDictionaryTincanValue(objectName) : this.model.get('obj');

            this.model.set({title: (this.language[verb] != undefined ? this.language[verb] : this.language[this.model.get('verb')])
                + ' ' + objectTitle});
        }
        else if (options.type == GOAL_TYPE.ACTIVITY) {
          this.model.set({
            isActivity: true,
            title: this.language[this.model.get('activityName')]
          });
        }
    },
    render: function () {
        var template = Mustache.to_html(jQuery('#goalRowTemplate').html(), _.extend(this.model.toJSON(), {
            canDelete: false,
            status: this.language[this.model.get('status')]}, this.language));
        this.$el.html(template);
        return this;
    }
});

TranscriptCertificateGoalView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.certificateID = options.certificateID;
        this.collection = options.certificates;
        this.statuses = options.statuses;
        this.statements = options.statements;
    },

    render: function() {
        var renderedTemplate = Mustache.to_html(jQuery('#certificateGoalsListTemplate').html(), _.extend(this.language));
        this.$el.append(renderedTemplate);

        this.addAll();

        return this;
    },

    addAll: function () {
        this.collection.each(
            function(item){
                if(item.attributes.courseCount > 0)
                    this.$el.find('#certificateCoursesTable').closest('div').toggleClass('hidden');
                if(item.attributes.statementCount > 0)
                    this.$el.find('#certificateStatementsTable').closest('div').toggleClass('hidden');
                if(item.attributes.activityCount > 0)
                    this.$el.find('#certificateActivitiesTable').closest('div').toggleClass('hidden');
                if(item.attributes.packageCount > 0)
                    this.$el.find('#lessonGoalsTable').closest('div').toggleClass('hidden');


                this.renderGoals(item.attributes.courseCount, this.statuses.get('courses'), GOAL_TYPE.COURSE);
                this.renderGoals(item.attributes.statementCount, this.statuses.get('statements'), GOAL_TYPE.STATEMENT);
                this.renderGoals(item.attributes.activityCount, this.statuses.get('activities'), GOAL_TYPE.ACTIVITY);
                this.renderGoals(item.attributes.packageCount, this.statuses.get('packages'), GOAL_TYPE.PACKAGE);
            }, this);
    },

    renderGoals: function (goals, statuses, type) {
        if (goals != undefined) {
            for (var i = 0; i < goals; i++) {
                var params;
                var item = new CertificateGoalStatus(statuses[i]);
                if (statuses != undefined) {
                    if (type == GOAL_TYPE.ACTIVITY) {
                        params = statuses.filter(function (i) {
                            return i.activityName == item.get('activityName')
                        }).map(function (i) {
                            return [i.status, i.dateFinish];
                        });
                    }
                    else if (type == GOAL_TYPE.STATEMENT) {
                        params = statuses.filter(function (i) {
                            return i.obj == item.get('obj') && i.verb == item.get('verb')
                        }).map(function (i) {
                            return [i.status, i.dateFinish];
                        });
                    }
                    else if (type == GOAL_TYPE.COURSE) {
                        params = statuses.filter(function (i) {
                            return i.courseId == item.get('courseId')
                        }).map(function (i) {
                            return [i.status, i.dateFinish, i.title];
                        });
                    }
                    else if (type == GOAL_TYPE.PACKAGE) {
                      params = statuses.filter(function (i) {
                        return i.packageId == item.get('packageId')
                      }).map(function (i) {
                        return [i.status, i.dateFinish, i.title];
                      });
                    }
                }


                var view = new GoalStatusView({model: item, status: params[0][0], certificateID: this.certificateID, statements: this.statements, type: type, language: this.language, dateFinish: params[0][1], title: params[0][2]});

                var template = view.render().$el;
                if (type == GOAL_TYPE.COURSE) {
                    this.$('#certificateCoursesTable').append(template);
                }
                else if (type == GOAL_TYPE.STATEMENT) {
                    this.$('#certificateStatementsTable').append(template);
                }
                else if (type == GOAL_TYPE.ACTIVITY) {
                    this.$('#certificateActivitiesTable').append(template);
                }
                else if (type == GOAL_TYPE.PACKAGE) {
                  this.$('#lessonGoalsTable').append(template);
                }
            }
        }
    }
});

var GOAL_TYPE = {
    COURSE: 1,
    STATEMENT: 2,
    ACTIVITY: 3,
    PACKAGE: 4
};