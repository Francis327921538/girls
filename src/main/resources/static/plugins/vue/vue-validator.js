/*!
 * vue-validator v3.0.0-alpha.2 
 * (c) 2016 kazuya kawaguchi
 * Released under the MIT License.
 */
!function(t,e){"object"==typeof exports&&"undefined"!=typeof module?module.exports=e():"function"==typeof define&&define.amd?define(e):t.VueValidator=e()}(this,function(){"use strict";function t(t,e){window.console&&(console.warn("[vue-validator] "+t),e&&console.warn(e.stack))}function e(t,i){var n=void 0===i||i;if(Array.isArray(t)){if(0!==t.length){for(var s=!0,r=0,a=t.length;r<a&&(s=e(t[r],n),!(n&&!s||!n&&s));r++);return s}return!n}return"number"==typeof t||"function"==typeof t?n:"boolean"==typeof t?t===n:"string"==typeof t?n?t.length>0:t.length<=0:null!==t&&"object"==typeof t?n?Object.keys(t).length>0:Object.keys(t).length<=0:null===t||void 0===t?!n:!n}function i(t,e){if("string"!=typeof e)return!1;var i=e.match(new RegExp("^/(.*?)/([gimy]*)$"));return!!i&&new RegExp(i[1],i[2]).test(t)}function n(t,e){return"string"==typeof t?o(e,10)&&t.length>=parseInt(e,10):!!Array.isArray(t)&&t.length>=parseInt(e,10)}function s(t,e){return"string"==typeof t?o(e,10)&&t.length<=parseInt(e,10):!!Array.isArray(t)&&t.length<=parseInt(e,10)}function r(t,e){return!isNaN(+t)&&!isNaN(+e)&&+t>=+e}function a(t,e){return!isNaN(+t)&&!isNaN(+e)&&+t<=+e}function o(t){return/^(-?[1-9]\d*|0)$/.test(t)}function u(t){return"string"==typeof t?[t]:t}function l(t){for(var e=[],i=0,n=t.options.length;i<n;i++){var s=t.options[i];!s.disabled&&s.selected&&e.push(s.value)}return e}function h(t){var e=t.className;return"object"==typeof e&&(e=e.baseVal||""),e}function c(t,e){K&&!/svg$/.test(t.namespaceURI)?t.className=e:t.setAttribute("class",e)}function d(t,e){if(t.classList)t.classList.add(e);else{var i=" "+h(t)+" ";i.indexOf(" "+e+" ")<0&&c(t,(i+e).trim())}}function f(t,e){if(t.classList)t.classList.remove(e);else{for(var i=" "+h(t)+" ",n=" "+e+" ";i.indexOf(n)>=0;)i=i.replace(n," ");c(t,i.trim())}t.className||t.removeAttribute("class")}function v(t,e,i){if(t){if(e=e.trim(),e.indexOf(" ")===-1)return void i(t,e);for(var n=e.split(/\s+/),s=0,r=n.length;s<r;s++)i(t,n[s])}}function p(t){var e=Object.create(null);return function(i){for(var n=[],s=arguments.length-1;s-- >0;)n[s]=arguments[s+1];var r=e[i];return r||(e[i]=t.apply(void 0,n))}}function g(t){return t.child&&t.componentOptions&&t.tag&&t.tag.match(/vue-component/)}function y(t){return!t.child&&!t.componentOptions&&t.tag}function _(t){return(t&&t.data&&t.data.directives||[]).find(function(t){return"model"===t.name})}function m(t){return t&&"function"==typeof t.then}function b(t,e,i){i.forEach(function(i){i&&i.componentOptions&&i.componentOptions.propsData&&"validity-control"===i.componentOptions.tag&&(i.componentOptions.propsData.validation={instance:t,name:e}),i.children&&b(t,e,i.children)})}function w(e){var i={};return E(e).forEach(function(e){var n=e.key,s=e.val;i[n]=function(){var e=this.$validation;if(!this._isMounted)return null;var i=s.split("."),n=i.shift();if("$validation"!==n)return t("unknown validation result path: "+s),null;var r,a=e;do r=i.shift(),a=a[r];while(i.length>0&&void 0!==a);return a}}),i}function E(t){return Array.isArray(t)?t.map(function(t){return{key:t,val:t}}):Object.keys(t).map(function(e){return{key:e,val:t[e]}})}function V(e,i){return void 0===i&&(i={}),et?void t("already installed."):(O(e),j(e),k(e),$(e),void(et=!0))}function k(t){t.mixin(C(t))}function $(t){var e=tt(t);Object.keys(e).forEach(function(i){t.component(i,e[i])})}var R={classes:{}},O=function(t){Object.defineProperty(t.config,"validator",{enumerable:!0,configurable:!0,get:function(){return R},set:function(t){R=t}})},M=Object.freeze({required:e,pattern:i,minlength:n,maxlength:s,min:r,max:a}),j=function(t){function e(e,i){return void 0===i?t.options.validators[e]:(t.options.validators[e]=i,void(null===i&&delete t.options.validators.id))}var i=t.util,n=i.extend,s=Object.create(null);n(s,M),t.options.validators=s;var r=t.config.optionMergeStrategies;r&&(r.validators=function(t,e){if(!e)return t;if(!t)return e;var i=Object.create(null);n(i,t);var s;for(s in e)i[s]=e[s];return i}),t.validator=e},x=function(t){var e=t.util,i=e.extend;return{data:function(){return{valid:!0,dirty:!1,touched:!1,modified:!1,results:{}}},computed:{invalid:function(){return!this.valid},pristine:function(){return!this.dirty},untouched:function(){return!this.touched},result:function(){var t={valid:this.valid,invalid:this.invalid,dirty:this.dirty,pristine:this.pristine,touched:this.touched,untouched:this.untouched,modified:this.modified},e=this.results;return this._validityKeys.forEach(function(i){if(t[i]=e[i],t[i].errors){var n=t.errors||[];t[i].errors.forEach(function(t){n.push(t)}),t.errors=n}}),t}},watch:{results:function t(e,i){var n=this._validityKeys,t=this.results;this.valid=this.checkResults(n,t,"valid",!0),this.dirty=this.checkResults(n,t,"dirty",!1),this.touched=this.checkResults(n,t,"touched",!1),this.modified=this.checkResults(n,t,"modified",!1)}},created:function(){this._validities=Object.create(null),this._validityWatchers=Object.create(null),this._validityKeys=[],this._committing=!1},destroyed:function(){var t=this;this._validityKeys.forEach(function(e){t._validityWatchers[e](),delete t._validityWatchers[e],delete t._validities[e]}),delete this._validityWatchers,delete this._validities,delete this._validityKeys},methods:{register:function(t,e){var i=this;this._validities[t]=e,this._validityKeys=Object.keys(this._validities),this.setResults(t,{}),this.withCommit(function(){i._validityWatchers[t]=e.$watch("result",function(e,n){i.setResults(t,e)},{deep:!0,immediate:!0})})},unregister:function(t){var e=this;this._validityWatchers[t](),delete this._validityWatchers[t],delete this._validities[t],this._validityKeys=Object.keys(this._validities),this.withCommit(function(){e.resetResults(t)})},validityCount:function(){return this._validityKeys.length},isRegistered:function(t){return t in this._validities},getValidityKeys:function(){return this._validityKeys},checkResults:function(t,e,i,n){for(var s=n,r=0;r<t.length;r++){var a=e[t[r]];if(a[i]!==n){s=!n;break}}return s},setResults:function(t,e){var n=this,s={};this._validityKeys.forEach(function(t){s[t]=i({},n.results[t])}),s[t]=i({},e),this.results=s},resetResults:function(t){var e=this,n={};this._validityKeys.forEach(function(s){t&&t!==s&&(n[s]=i({},e.results[s]))}),this.results=n},withCommit:function(t){var e=this._committing;this._committing=!0,t(),this._committing=e}}}},I=function(t){var e=x(t),i=function(e){void 0===e&&(e={}),this._result={},this._host=e.host,this._named=Object.create(null),this._group=Object.create(null),this._validities=Object.create(null),this._beginDestroy=!1,t.util.defineReactive(this._host,"$validation",this._result)};return i.prototype.register=function(i,n,s){if(void 0===s&&(s={}),this._validityManager||(this._validityManager=new t(e),this._watchValidityResult()),!this._validities[i]){this._validities[i]=n;var r=s.named,a=s.group,o=a?this._getValidityGroup("group",a)||this._registerValidityGroup("group",a):null,u=r?this._getValidityGroup("named",r)||this._registerValidityGroup("named",r):null;r&&a&&u&&o?(o.register(i,n),!u.isRegistered(a)&&u.register(a,o),!this._validityManager.isRegistered(r)&&this._validityManager.register(r,u)):u?(u.register(i,n),!this._validityManager.isRegistered(r)&&this._validityManager.register(r,u)):o?(o.register(i,n),!this._validityManager.isRegistered(a)&&this._validityManager.register(a,o)):this._validityManager.register(i,n)}},i.prototype.unregister=function(t,e){if(void 0===e&&(e={}),this._validityManager&&this._validities[t]){delete this._validities[t];var i=e.named,n=e.group,s=n?this._getValidityGroup("group",n):null,r=i?this._getValidityGroup("named",i):null;i&&n&&r&&s?(s.unregister(t),0===s.validityCount()&&(r.isRegistered(n)&&r.unregister(n),this._unregisterValidityGroup("group",n)),0===r.validityCount()&&(this._validityManager.isRegistered(i)&&this._validityManager.unregister(i),this._unregisterValidityGroup("named",i))):i&&r?(r.unregister(t),0===r.validityCount()&&(this._validityManager.isRegistered(i)&&this._validityManager.unregister(i),this._unregisterValidityGroup("named",i))):n&&s?(s.unregister(t),0===s.validityCount()&&(this._validityManager.isRegistered(n)&&this._validityManager.unregister(n),this._unregisterValidityGroup("group",n))):this._validityManager.unregister(t)}},i.prototype.destroy=function(){var t=this,e=Object.keys(this._validities),i=Object.keys(this._named),n=Object.keys(this._group);e.forEach(function(e){n.forEach(function(i){var n=t._getValidityGroup("group",i);n&&n.isRegistered(i)&&n.unregister(e)}),i.forEach(function(i){var n=t._getValidityGroup("named",i);n&&n.isRegistered(e)&&n.unregister(e)}),t._validityManager.isRegistered(e)&&t._validityManager.unregister(e),delete t._validities[e]}),n.forEach(function(e){i.forEach(function(i){var n=t._getValidityGroup("named",i);n&&n.isRegistered(e)&&n.unregister(e)}),t._validityManager.isRegistered(e)&&t._validityManager.unregister(e),t._unregisterValidityGroup("group",e)}),i.forEach(function(e){t._validityManager.isRegistered(e)&&t._validityManager.unregister(e),t._unregisterValidityGroup("named",e)}),this._beginDestroy=!0},i.prototype._getValidityGroup=function(t,e){return"named"===t?this._named[e]:this._group[e]},i.prototype._registerValidityGroup=function(i,n){var s="named"===i?this._named:this._group;return s[n]=new t(e),s[n]},i.prototype._unregisterValidityGroup=function(t,e){var i="named"===t?this._named:this._group;i[e]&&(i[e].$destroy(),delete i[e])},i.prototype._watchValidityResult=function(){var e=this;this._watcher=this._validityManager.$watch("results",function(i,n){t.set(e._host,"$validation",i),e._beginDestroy&&e._destroyValidityMananger()},{deep:!0})},i.prototype._unwatchValidityResult=function(){this._watcher(),delete this._watcher},i.prototype._destroyValidityMananger=function(){this._unwatchValidityResult(),this._validityManager.$destroy(),this._validityManager=null},i},C=function(t){var e=I(t);return{beforeCreate:function(){this._validation=new e({host:this})}}},S={field:{type:String,required:!0},validators:{type:[String,Array,Object],required:!0},group:{type:String},multiple:{type:Boolean},autotouch:{type:String,default:function(){return"on"}},classes:{type:Object,default:function(){return{}}}},T={valid:"valid",invalid:"invalid",touched:"touched",untouched:"untouched",pristine:"pristine",dirty:"dirty",modified:"modified"},L=function(t){function e(t,e,i){void 0===i&&(i=void 0),Array.isArray(e)?e.forEach(function(e){t[e]=i}):Object.keys(e).forEach(function(n){var s=e[n]&&e[n].props&&o(e[n].props)?e[n].props:null;s?Object.keys(s).forEach(function(e){t[n]={},t[n][e]=i}):t[n]=i})}function i(t){var i={};return e(i,t,void 0),i}function n(t){var i={};return e(i,t,""),i}function s(){var t=u(this.validators);return{results:i(t),valid:!0,dirty:!1,touched:!1,modified:!1,progresses:n(t)}}var r=t.util,a=r.extend,o=r.isPlainObject,l=a({child:{type:Object,required:!0},value:{type:Object}},S);return{props:l,data:s}},P=function(t){function e(t,e,i,n,s){var r={field:e,validator:i};n&&(r.message=n),s&&(r.prop=s),t.errors=t.errors||[],t.errors.push(r)}function i(t,e){for(var n="",s=0;s<t.length;s++){var r=e[t[s]];if("string"==typeof r&&r){n=r;break}if(l(r)){var a=Object.keys(r);if(n=i(a,r),!n)break}}return n}function n(){return!this.valid}function s(){return!this.dirty}function r(){return!this.touched}function a(){var t=this,i={valid:this.valid,invalid:this.invalid,dirty:this.dirty,pristine:this.pristine,touched:this.touched,untouched:this.untouched,modified:this.modified},n=this._keysCached(this._uid.toString(),this.results);return n.forEach(function(n){var s=t.results[n];if("boolean"==typeof s)s?i[n]=!1:(e(i,t.field,n),i[n]=!s);else if("string"==typeof s)e(i,t.field,n,s),i[n]=s;else if(l(s)){var r=Object.keys(s);r.forEach(function(r){var a=s[r];i[r]=i[r]||{},"boolean"==typeof a?a?i[r][n]=!1:(e(i,t.field,n,void 0,r),i[r][n]=!a):"string"==typeof a?(e(i,t.field,n,a,r),i[r][n]=a):i[r][n]=!1})}else i[n]=!1}),i}function o(){var t="";return t=i(this._keysCached(this._uid.toString(),this.results),this.progresses)}var u=t.util,l=u.isPlainObject;return{invalid:n,pristine:s,untouched:r,result:a,progress:o}},G=function(t){return{render:function(t){return this.child}}},D=function(t){var e=t.util,i=e.looseEqual,n=function(t){this._vm=t,this.initValue=this.getValue(),this.attachValidity()};return n.prototype.attachValidity=function(){this._vm.$el.$validity=this._vm},n.prototype.getValue=function(){var t=this._vm.$el;return"SELECT"===t.tagName?l(t):"checkbox"===t.type?t.checked:t.value},n.prototype.checkModified=function(){var t=this._vm.$el;return"SELECT"===t.tagName?!i(this.initValue,l(t)):"checkbox"===t.type?!i(this.initValue,t.checked):!i(this.initValue,t.value)},n.prototype.listenToucheableEvent=function(){this._vm.$el.addEventListener("focusout",this._vm.willUpdateTouched)},n.prototype.unlistenToucheableEvent=function(){this._vm.$el.removeEventListener("focusout",this._vm.willUpdateTouched)},n.prototype.listenInputableEvent=function(){var t=this._vm,e=t.$el;"SELECT"===e.tagName?e.addEventListener("change",t.handleInputable):"checkbox"===e.type?e.addEventListener("change",t.handleInputable):e.addEventListener("input",t.handleInputable)},n.prototype.unlistenInputableEvent=function(){var t=this._vm,e=t.$el;"SELECT"===e.tagName?e.removeEventListener("change",t.handleInputable):"checkbox"===e.type?e.removeEventListener("change",t.handleInputable):e.removeEventListener("input",t.handleInputable)},n},A=function(t){var e=t.util,i=e.looseEqual,n=function(t){this._vm=t,this.initValue=this.getValue(),this.attachValidity()};return n.prototype.attachValidity=function(){var t=this;this._vm.$el.$validity=this._vm,this._eachItems(function(e){e.$validity=t._vm})},n.prototype.getValue=function(){return this._getCheckedValue()},n.prototype.checkModified=function(){return!i(this.initValue,this._getCheckedValue())},n.prototype.listenToucheableEvent=function(){var t=this;this._eachItems(function(e){e.addEventListener("focusout",t._vm.willUpdateTouched)})},n.prototype.unlistenToucheableEvent=function(){var t=this;this._eachItems(function(e){e.removeEventListener("focusout",t._vm.willUpdateTouched)})},n.prototype.listenInputableEvent=function(){var t=this;this._eachItems(function(e){e.addEventListener("change",t._vm.handleInputable)})},n.prototype.unlistenInputableEvent=function(){var t=this;this._eachItems(function(e){e.removeEventListener("change",t._vm.handleInputable)})},n.prototype._getCheckedValue=function(){var t=[];return this._eachItems(function(e){!e.disabled&&e.checked&&t.push(e.value)}),t},n.prototype._getItems=function(){return this._vm.$el.querySelectorAll('input[type="checkbox"], input[type="radio"]')},n.prototype._eachItems=function(t){for(var e=this._getItems(),i=0;i<e.length;i++)t(e[i])},n},N="undefined"!=typeof window&&"[object Object]"!==Object.prototype.toString.call(window),U=N&&window.navigator.userAgent.toLowerCase(),K=U&&U.indexOf("msie 9.0")>0,q=function(t){function e(t){var e="string"==typeof t?[t]:t,i=[];return s(e)&&Object.keys(e).forEach(function(t){var n=e[t]&&e[t].props&&s(e[t].props)?e[t].props:null;n&&Object.keys(n).forEach(function(t){~i.indexOf(t)||i.push(t)})}),i}var i=t.util,n=i.looseEqual,s=i.isPlainObject,r=function(t,i,n){this._vm=t,this._vnode=i,this._validatorProps=n||p(e),this.initValue=this.getValue(),this._watchers=[],this.attachValidity()};return r.prototype.attachValidity=function(){this._vm.$el.$validity=this._vm},r.prototype.getValidatorProps=function(){var t=this._vm;return this._validatorProps(t._uid.toString(),t.validators)},r.prototype.getValue=function(){var t=this,e={};return this.getValidatorProps().forEach(function(i){e[i]=t._vnode.child[i]}),e},r.prototype.checkModified=function(){return!n(this.initValue,this.getValue())},r.prototype.listenToucheableEvent=function(){this._vm.$el.addEventListener("focusout",this._vm.willUpdateTouched)},r.prototype.unlistenToucheableEvent=function(){this._vm.$el.removeEventListener("focusout",this._vm.willUpdateTouched)},r.prototype.listenInputableEvent=function(){var t=this;this.getValidatorProps().forEach(function(e){t._watchers.push(t._vnode.child.$watch(e,t._vm.watchInputable))})},r.prototype.unlistenInputableEvent=function(){this._watchers.forEach(function(t){t()}),this._watchers=[]},r},W=function(t){var e=D(t),i=A(t),n=q(t);return{SingleElement:e,MultiElement:i,ComponentElement:n}},z=function(t){function e(t,e){return t.multiple?new u(t):y(e)?new o(t):g(e)?new l(t,e):null}function i(t){this.$emit("input",{result:this.result,progress:this.progress,progresses:this.progresses})}function n(){this._elementable=null,this._keysCached=p(function(t){return Object.keys(t)}),this._modified=!1,this._watchValidationRawResults();var t=this.$options.propsData?this.$options.propsData.validation:null;if(t){var e=t.instance,i=t.name,n=this.group;e.register(this.field,this,{named:i,group:n})}}function s(){var t=this.$options.propsData?this.$options.propsData.validation:null;if(t){var e=t.instance,i=t.name,n=this.group;e.unregister(this.field,{named:i,group:n})}this._unwatchResultProp&&(this._unwatchResultProp(),this._unwatchResultProp=null),this._unwatchProgressProp&&(this._unwatchProgressProp(),this._unwatchProgressProp=null),this._unwatchValidationRawResults(),this._elementable.unlistenInputableEvent(),"on"===this.autotouch&&this._elementable.unlistenToucheableEvent(),this._elementable=null}function r(){this._elementable=e(this,this._vnode),this._elementable&&("on"===this.autotouch&&this._elementable.listenToucheableEvent(),this._elementable.listenInputableEvent()),_(this.$vnode)&&(this._unwatchResultProp=this.$watch("result",i),this._unwatchProgressProp=this.$watch("progress",i)),v(this.$el,this.classes.untouched,d),v(this.$el,this.classes.pristine,d)}var a=W(t),o=a.SingleElement,u=a.MultiElement,l=a.ComponentElement;return{created:n,destroyed:s,mounted:r}},B=function(t){function e(t){for(var e=[],i=arguments.length-1;i-- >0;)e[i]=arguments[i+1];(n=this).$emit.apply(n,[t].concat(e));var n}return{_fireEvent:e}},F=function(t){function e(t){return this._elementable.getValue()}function i(){return this._elementable.checkModified()}function n(t){this.touched||(this.touched=!0,v(this.$el,this.classes.touched,d),v(this.$el,this.classes.untouched,f),this._fireEvent("touched"))}function s(){!this.dirty&&this.checkModified()&&(this.dirty=!0,v(this.$el,this.classes.dirty,d),v(this.$el,this.classes.pristine,f),this._fireEvent("dirty"))}function r(){var t=this.modified=this.checkModified();this._modified!==t&&(this._modified=t,v(this.$el,this.classes.modified,t?d:f),this._fireEvent("modified",t))}function a(t){this.willUpdateDirty(),this.willUpdateModified()}function o(t){this.willUpdateDirty(),this.willUpdateModified()}function u(t,e,i){void 0===i&&(i=void 0);for(var n=0;n<t.length;n++){var s=e[t[n]];if(_(s)){var r=Object.keys(s);u(r,s,i)}else e[t[n]]=i}}function l(){this._unwatchValidationRawResults();var t=this._keysCached(this._uid.toString(),this.results);u(t,this.results,void 0),u(t,this.progresses,""),v(this.$el,this.classes.valid,f),v(this.$el,this.classes.invalid,f),v(this.$el,this.classes.touched,f),v(this.$el,this.classes.untouched,d),v(this.$el,this.classes.dirty,f),v(this.$el,this.classes.pristine,d),v(this.$el,this.classes.modified,f),this.valid=!0,this.dirty=!1,this.touched=!1,this.modified=!1,this._modified=!1,this._watchValidationRawResults()}function h(t,e){for(var i=!0,n=0;n<t.length;n++){var s=e[t[n]];if("boolean"==typeof s&&!s){i=!1;break}if("string"==typeof s&&s){i=!1;break}if(_(s)){var r=Object.keys(s);if(i=h(r,s),!i)break}}return i}function c(){var t=this;this._unwatchResults=this.$watch("results",function(e){t.valid=h(t._keysCached(t._uid.toString(),t.results),t.results),t.valid?(v(t.$el,t.classes.valid,d),v(t.$el,t.classes.invalid,f)):(v(t.$el,t.classes.valid,f),v(t.$el,t.classes.invalid,d)),t._fireEvent(t.valid?"valid":"invalid")},{deep:!0})}function p(){this._unwatchResults(),this._unwatchResults=void 0,delete this._unwatchResults}function g(){this.willUpdateTouched()}var y=t.util,_=y.isPlainObject;return{getValue:e,checkModified:i,willUpdateTouched:n,willUpdateDirty:s,willUpdateModified:r,handleInputable:a,watchInputable:o,reset:l,_walkValid:h,_watchValidationRawResults:c,_unwatchValidationRawResults:p,touch:g}},H=function(t){function e(t){var e=this.child&&this.child.context?this.child.context.$options:this.$options;return d(e,"validators",t)}function i(t,e,i){var n=this._resolveValidator(t);if(!n)return null;var s=null,r=null,a=null;if(c(n))n.check&&"function"==typeof n.check&&(s=n.check),n.message&&(a=n.message);else{if("function"!=typeof n)return null;s=n}if(!s)return null;var o=null,u=this.validators;c(u)&&(c(u[t])?u[t].props&&c(u[t].props)?o=u[t].props:(u[t].rule&&(r=u[t].rule),u[t].message&&(a=u[t].message)):r=u[t]);var l={fn:s,value:i,field:e};return r&&(l.rule=r),a&&(l.msg=a),o&&(l.props=o),l}function n(t,e,i){return i?i:e?"function"==typeof e?e(t):e:void 0}function s(t,e,i){var n=this,s=t.fn,r=t.field,a=t.rule,o=t.msg,u=s.call(this.child.context,e,a);"function"==typeof u?u(function(){i(!0)},function(t){i(!1,n._resolveMessage(r,o,t))}):m(u)?u.then(function(){i(!0)},function(t){i(!1,n._resolveMessage(r,o,t))}).catch(function(t){i(!1,n._resolveMessage(r,o,t.message))}):i(u,u===!1?this._resolveMessage(r,o):void 0)}function r(t,e,i){var n=[],s=this._getValidateRawDescriptor(t,this.field,i);if(!s)return n;if(s.props){var r=Object.keys(!s.props);r.forEach(function(e){var i={fn:s.fn,name:t,value:s.value[e],field:s.field,prop:e};s.props[e].rule&&(i.rule=s.props[e].rule),s.props[e].message&&(i.msg=s.props[e].message),n.push(i)})}else{var a={name:t};h(a,s),n.push(a)}return n}function a(t,e){var i=this,n=this._keysCached(this._uid.toString(),this.results),s=this.getValue(),r=[];n.forEach(function(e){i._getValidateDescriptors(e,t,s).forEach(function(t){r.push(t)})});var a=0,o=r.length;r.forEach(function(t){var n=t.name,s=t.prop;return!s&&i.progresses[n]||s&&i.progresses[n][s]?(a++,void(a===o&&e(i._walkValid(i._keysCached(i._uid.toString(),i.results),i.results)))):(s?i.progresses[n][s]="running":i.progresses[n]="running",void i.$nextTick(function(){i._invokeValidator(t,t.value,function(t,r){s?(i.progresses[n][s]="",i.results[n][s]=r||t):(i.progresses[n]="",i.results[n]=r||t),a++,a===o&&e(i._walkValid(i._keysCached(i._uid.toString(),i.results),i.results))})}))})}function o(t,e,i){var n=this,s=this._getValidateRawDescriptor(t,this.field,e);if(s&&!s.props){if(this.progresses[t])return!1;this.progresses[t]="running",this.$nextTick(function(){n._invokeValidator(s,s.value,function(e,s){if(n.progresses[t]="",n.results[t]=s||e,i)n.$nextTick(function(){i.call(n,null,e,s)});else{var r={result:e};s&&(r.msg=s),n._fireEvent("validate",t,r)}})})}else if(s&&s.props){var r=Object.keys(s.props);r.forEach(function(e){if(!n.progresses[t][e]){n.progresses[t][e]="running";var i=s.value,r={fn:s.fn,value:i[e],field:s.field};s.props[e].rule&&(r.rule=s.props[e].rule),s.props[e].message&&(r.msg=s.props[e].message),n.$nextTick(function(){n._invokeValidator(r,r.value,function(i,s){n.progresses[t][e]="",n.results[t][e]=s||i;var r={prop:e,result:i};s&&(r.msg=s),n._fireEvent("validate",t,r)})})}})}else{var a=new Error;i?i.call(this,a):this._fireEvent("validate",t,a)}return!0}function u(){for(var t=this,e=[],i=arguments.length;i--;)e[i]=arguments[i];var n,s,r,a=!0;return 3===e.length?(n=[e[0]],s=e[1],r=e[2]):2===e.length?c(e[0])?(n=[e[0].validator],s=e[0].value||this.getValue(),r=e[1]):(n=this._keysCached(this._uid.toString(),this.results),s=e[0],r=e[1]):1===e.length?(n=this._keysCached(this._uid.toString(),this.results),s=this.getValue(),r=e[0]):(n=this._keysCached(this._uid.toString(),this.results),s=this.getValue(),r=null),3===e.length||2===e.length&&c(e[0])?a=this._validate(n[0],s,r):n.forEach(function(e){a=t._validate(e,s,r)}),a}var l=t.util,h=l.extend,c=l.isPlainObject,d=l.resolveAsset;return{_resolveValidator:e,_getValidateRawDescriptor:i,_getValidateDescriptors:r,_resolveMessage:n,_invokeValidator:s,_validate:o,_syncValidates:a,validate:u}},J=function(t){var e=t.util,i=e.extend,n={};return i(n,B(t)),i(n,F(t)),i(n,H(t)),n},Q=function(t){var e=t.util,i=e.extend,n=L(t),s=n.props,r=n.data,a=P(t),o=z(t),u=G(t),l=u.render,h=J(t),c={props:s,data:r,render:l,computed:a,methods:h};return i(c,o),c},X=function(t){var e=t.util,i=e.extend;return{functional:!0,props:S,render:function(e,n){var s=n.props,r=n.data,a=n.children;return a.map(function(n){if(!n.tag)return n;var a=i({},r);return a.props=i({},s),a.props.classes=i(i(i({},T),t.config.validator.classes),a.props.classes),a.props.child=n,e("validity-control",a)})}}},Y=function(t){var e=t.util,i=e.extend,n=i({tag:{type:String,default:"fieldset"}},S);return{functional:!0,props:n,render:function(e,n){var s=n.props,r=n.data,a=n.children,o=e(s.tag,a),u=i({},r);return u.props=i({},s),u.props.classes=i(i(i({},T),t.config.validator.classes),u.props.classes),u.props.child=o,u.props.multiple=!0,e("validity-control",u)}}},Z=function(t){var e=t.util,i=e.extend;return{functional:!0,props:{name:{type:String},tag:{type:String,default:"form"}},render:function(t,e){var n=e.props,s=e.data,r=e.parent,a=e.children;e.slots;if(!r._validation)return a;var o=n.tag||"form";b(r._validation,n.name,a);var u=i({attrs:{}},s);return"form"===o&&(u.attrs.novalidate=!0),t(o,u,a)}}},tt=function(t){return{"validity-control":Q(t),validity:X(t),"validity-group":Y(t),validation:Z(t)}},et=!1;V.mapValidation=w,V.version="3.0.0-alpha.2","undefined"!=typeof window&&window.Vue&&window.Vue.use(V);var it={install:V,mapValidation:w};return it});