/**
 * Created by ArjunNaga on 9/24/16.
 */


(function() {
  'use strict';

  angular
    .module('client')
    .controller('MoviePageController', MoviePageController );

  /** @ngInject */
  function MoviePageController($timeout, movies) {
    var vm = this;

    vm.status1 = false;
    vm.status2 = false;
    vm.status3 = false;


    vm.moviesList = movies.getMovies();
    vm.singleMovie = movies.getMovie;
    vm.setMovieId = setMovieId;

    vm.toggleType = toggleType;
    vm.toggleGenre = toggleGenre;
    vm.toggleSort = toggleSort;

    vm.reset = reset;


    function reset() {
      vm.movieType = '';
      vm.movieGenre = '';
      vm.movieSort = '';
    }

    function toggleType(type) {
      reset();
      vm.movieType = type;
    }

    function toggleGenre(genre) {
      reset();
      vm.movieGenre = genre;
    }

    function toggleSort(sort) {
      reset();
      vm.movieSort = sort;

    }

   function setMovieId(id) {
      movies.movieId = id;
      console.log('movieId' + id);
    }

    movies.getMovies().then(function (res) {
      vm.moviesList = res.data;
    }, function (err) {
      alert(err.message);
    });


  }

})();
