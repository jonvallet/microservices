var customer = angular.module('customer', []);

customer.controller('customerCtrl', function ($scope, $http) {

    $scope.register = function (data) {
         $http.post('/customers/register', data)
             .error(function(error){
                console.log(error)
                $scope.show_success = false

                if (error.error === "Conflict"){
                    $scope.show_conflict = true
                }else {
                    $scope.show_error = true
                }
             })
             .success(function(data) {
                    console.log(data)
                    $scope.show_success = true
                    $scope.show_error = false
                    $scope.show_conflict = false
             })
    }
});