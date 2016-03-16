(function() {
  'use strict';

  angular
    .module('plunker')
    .service('userService', userService);

  userService.$inject = ['$http', '$q', 'CONFIG'];

  function userService($http, $q, CONFIG) {
    var self = this;

    self.getUsers = getUsers;
    self.createUser = createUser;
    self.updateUser = updateUser;
    self.deleteUser = deleteUser;

    function getUsers() {
      return $http.get(CONFIG.API_END_POINT + '/users')
        .then(successFn, errorFn);
    }

    function createUser(user) {
      return $http.post(CONFIG.API_END_POINT + '/users', user)
        .then(successFn, errorFn);
    }

    function updateUser(userId, user) {
      return $http.put(CONFIG.API_END_POINT + '/users/' + userId, user)
        .then(successFn, errorFn);
    }

    function deleteUser(userId) {
      return $http.delete(CONFIG.API_END_POINT + '/users/' + userId)
        .then(successFn, errorFn);
    }

    function successFn(response) {
      return response.data;
    }

    function errorFn(errorResponse) {
      console.log(errorResponse.status);
      $q.reject(errorResponse.status);
    }
  
  }
})();