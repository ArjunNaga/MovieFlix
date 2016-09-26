/**
 * Created by ArjunNaga on 9/24/16.
 */


(function() {
  'use strict';

  angular
    .module('client')
    .controller('MovieDetailsController', MovieDetailsController );

  /** @ngInject */
  function MovieDetailsController($timeout, movies) {
    var vm = this;
    vm.Detail="";

    movies.getMovie(movies.movieId).then(function (res) {
      vm.Detail = res.data;
      //console.log(vm.Detail);
    }, function (err) {
      alert(err.message);
    })
  }
})();
