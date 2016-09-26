(function() {
  'use strict';

  angular
    .module('client')
    .service('movies', movies);

  /** @ngInject */
  function movies($http,baseUrl) {

    this.getMovies = getMovies;
    this.getMovie = getMovie;
    this.movieId = '';

    function getMovies() {
     return $http.get(baseUrl+'movies');
    }
    function getMovie(id) {
      return $http.get(baseUrl+'movies/'+id);
    }

  }
})();
/**
 * Created by ArjunNaga on 9/24/16.
 */
