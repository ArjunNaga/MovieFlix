/**
 * Created by ArjunNaga on 9/24/16.
 */


(function() {
  'use strict';

  angular
    .module('client')
    .controller('MoviePageController', MoviePageController );

  /** @ngInject */
  function MoviePageController($timeout, webDevTec, toastr) {
    var vm = this;

    vm.status1 = false;
    vm.status2 = false;
    vm.status3=false;

  }
})();
