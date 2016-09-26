/* global malarkey:false, moment:false */
(function() {
  'use strict';

  angular
    .module('client')
    .constant('malarkey', malarkey)
    .constant('moment', moment)
    .constant('baseUrl', 'http://localhost:8080/movieflix/api/');

})();
