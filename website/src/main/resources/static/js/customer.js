var customer = angular.module('customer', []);

customer.controller('customerCtrl', function ($scope, $http) {

    $scope.register = function (data, retry) {
         retry = retry || 0
         resetMessages()
         $scope.show_registering = true
         $http.post('/customers/register', data)
             .error(function(error){
                console.log(error)
                if (error.error === "Conflict"){
                    $scope.show_registering = false
                    $scope.show_conflict = true
                }else if(retry < 3) {
                    console.log("Retrying...")
                    $scope.register(data, retry + 1)
                } else {
                    $scope.show_registering = false
                    $scope.show_error = true
                }
             })
             .success(function(data) {
                    console.log(data)
                    $scope.show_registering = false
                    $scope.show_success = true
             })
    }

    function resetMessages() {
        $scope.show_success = false
        $scope.show_error = false
        $scope.show_conflict = false
        $scope.show_registering = false
    }
});