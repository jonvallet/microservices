var app = angular.module('app', []);

app.controller('appCtrl', function ($scope, $http) {

    $scope.backend_service = {}

    $scope.getBackendInfo = function () {
         $http.get('/rest-template/backend')
             .error(function(error){
                console.log(error)
             })
             .success(function(data) {
                    console.log(data)
                    $scope.backend_service = data
             })
    }

});