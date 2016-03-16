(function() {
  'use strict';

  angular
    .module('plunker')
    .controller('MainController', MainController);

  MainController.$inject = ['userService'];
  function MainController(userService) {
    var mainVm = this;
    
    mainVm.addUser = addUser;
    mainVm.deleteUser = deleteUser;

    init();

    function init() {
      userService
        .getUsers()
        .then(function(data) {
            mainVm.users = data;
          },
          function(error) {
            console.log(error);
          });
    }

    function addUser() {
      userService
        .createUser(mainVm.newUser)
        .then(function(data) {
          mainVm.newUser = null;
          return userService.getUsers();
        })
        .then(function(data) {
          mainVm.users = data;
        })
        .catch(function(error) {
          console.log(error);
        })
    }
    
    function deleteUser(userId) {
      userService
        .deleteUser(userId)
        .then(function(data) {
          return userService.getUsers();
        })
        .then(function(data) {
          mainVm.users = data;
        })
        .catch(function(error) {
          console.log(error);
        })
    }
  }
})();