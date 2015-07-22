/* Setup ptoper controller */
MetronicApp.controller('PtdeptController', ['$rootScope', '$scope', '$http', 'settings', function ($rootScope, $scope, $http, settings) {

    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();

    });
    //$scope.records  = [{"deptid":"810201012","deptname":"日照银行青岛分行营业部","deptdesc":"日照银行青岛分行营业部","parentdeptid":"010","fillint4":0,"deptindex":1},{"deptid":"810201011","deptname":"日照银行青岛分行营业部","deptdesc":"日照银行青岛分行营业部","parentdeptid":"010","fillint4":0,"deptindex":1}];

    $http.get('/skyline/platform/ptdept').
        success(function (data, status, headers) {
            $scope.records = data;
        }).
        error(function (data, status, headers) {
            $scope.errmsg = headers.errmsg;
        });
}]);
