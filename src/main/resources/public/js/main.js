var app = angular.module("springDemo", []);

app.controller('AppCtrl', function ($scope, $http) {
    $scope.websites = [];
    $http.get('/api/providers').success(function(response) {
        $scope.websites = response;
    });
});