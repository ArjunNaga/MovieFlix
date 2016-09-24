(function() {
  'use strict';

  angular
    .module('client')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
/*      .state('home', {
        url: '/',
        templateUrl: 'app/main/main.html',
        controller: 'MainController',
        controllerAs: 'main'
      })*/
      .state('signUp', {
        url: '/signUp',
        templateUrl: 'app/signUp/signUp.html',
        controller: 'SignUpController',
        controllerAs: 'signUp'
      })
      .state('login', {
      url: '/',
      templateUrl: 'app/login/login.html',
      controller: 'LoginController',
      controllerAs: 'login'
    })
      .state('moviePage', {
        url: '/movies',
        templateUrl: 'app/moviePage/moviePage.html',
        controller: 'MoviePageController',
        controllerAs: 'moviePage'
      })
      .state('movieDetails', {
        url: '/details',
        templateUrl: 'app/movieDetails/movieDetails.html',
        controller: 'MovieDetailsController',
        controllerAs: 'movieDetails'
      })
      .state('movieAdd', {
        url: '/add',
        templateUrl: 'app/movieAdd/movieAdd.html',
        controller: 'MovieAddController',
        controllerAs: 'movieAdd'
      })

    ;

    $urlRouterProvider.otherwise('/');
  }

})();
