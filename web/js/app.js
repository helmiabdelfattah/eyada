 
var app = angular.module('myApp', []);
app.controller('formCtrl', function($scope,$http) {
      
  $scope.newcure = function(){
        
          return $http.post("cure",
          { name:$scope.cuer.name,
          category:$scope.cuer.category ,
          formate:$scope.cuer.format})
        .then(function (response) {
            return response;
        });
  
  };
    $scope.newreport = function(){
        
          return $http.post("report",
          { type:$scope.report.type,
           note:$scope.report.note
          
           })
        .then(function (response) {
            return response;
        });
  
  };
    $scope.neweyedis = function(){
        
          return $http.post("eyedis",
          { name:$scope.eyedis.name,
           category:$scope.eyedis.category,
           note:$scope.eyedis.note
          
           })
        .then(function (response) {
            return response;
        });
  
  };
    $scope.newcordis = function(){
        
          return $http.post("cordis",
          { name:$scope.cordis.name,
           type:$scope.cordis.type,
           note:$scope.cordis.note
           })
        .then(function (response) {
            return response;
        });
  
  };
  
  
  //init
 //cure  
        $http.get("cure")
    .then(function(response) {
        $scope.curedata = response.data.cure;
     });
 
        $http.get("cure?req=cat")
    .then(function(response) {
        $scope.curecat = response.data.cure;
     });
 
        $http.get("cure?req=format")
    .then(function(response) {
        $scope.cureformat = response.data.cure;
 
     });
 
 //eyedis  
        $http.get("eyedis")
    .then(function(response) {
        $scope.eyedisdata = response.data.eye_diseases;
     });
        $http.get("eyedis?req=cat")
    .then(function(response) {
        $scope.eyediscat = response.data.eye_diseases;
     });
 
 //cordis  
        $http.get("cordis")
    .then(function(response) {
        $scope.cordisdata = response.data.chronic_disease;
     });
 
 
 //report
  $http.get("report")
    .then(function(response) {
        $scope.reportdata = response.data.report;
        
    });
  
  
  //filters 
  
  $scope.disbycat = function (item) { 
      if ($scope.rescatdisease == null || $scope.rescatdisease== "null" ) return true;
    return item.cat == $scope.rescatdisease  ;
};


  $scope.curebycat = function (item) { 
      if ($scope.resCureCategory == null|| $scope.resCureCategory == "null") return true;
    return item.catregory == $scope.resCureCategory  ;
};


  $scope.formatbycure = function (item) { 
      
    return item.describtion == $scope.rescure  ;
     
};


//add line in pres
   $scope.prelines = [];
  $scope.apply = function(){
        var line = {
            "cure" : $scope.rescure,
            "format" : $scope.rescureformat,
            "times" : $scope.pretimes,
            "Duration" : $scope.preduration,
            "Amount" : $scope.preamount,
            "place": $scope.preplace,   
            "note": $scope.prenote   
        }
           $scope.prelines.push(line);
           
           $scope.rescure=null;
            $scope.rescureformat= null;
            $scope.pretimes = null;
           $scope.preduration=null;
            $scope.preamount= null;
            $scope.preplace = null;
            $scope.prenote = null;
  };



});
 