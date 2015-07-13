'use strict';

/* Controllers */

skyline.controller('operctrl', ['$scope', '$http', function ($scope, $http) {
    $http.get("http://localhost:8080/skyline/platform/ptoper")
        .success(function (data) {
            $scope.opers = data;
        });
}]);
