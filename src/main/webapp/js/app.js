
var app = angular.module("myApp", []);
app.controller('formCtrl', function ($scope, $http) {

    $scope.newcure = function () {

        return $http.post("cure",
                {name: $scope.cuer.name,
                    category: $scope.cuer.category,
                    formate: $scope.cuer.format
                })
                .then(function (response) {
                    return response;
                });

    };
    $scope.newreport = function () {

        return $http.post("report",
                {type: $scope.report.type,
                    note: $scope.report.note

                })
                .then(function (response) {
                    return response;
                });

    };
    $scope.neweyedis = function () {

        return $http.post("eyedis",
                {name: $scope.eyedis.name,
                    category: $scope.eyedis.category,
                    note: $scope.eyedis.note

                })
                .then(function (response) {
                    return response;
                });

    };
    $scope.newcordis = function () {

        return $http.post("cordis",
                {name: $scope.cordis.name,
                    type: $scope.cordis.type,
                    note: $scope.cordis.note
                })
                .then(function (response) {
                    return response;
                });

    };

    $scope.patientTableData = ["first_name", "address_1", "age", "phone"];


    //init
    //cure  
    $http.get("cure")
            .then(function (response) {
                $scope.curedata = response.data.cure;
            });

    $http.get("cure?req=cat")
            .then(function (response) {
                $scope.curecat = response.data.cure;
            });

    $http.get("cure?req=format")
            .then(function (response) {
                $scope.cureformat = response.data.cure;

            });



    $scope.editshow = function (ida)
    {
        $scope.currentid = ida;
        for (x in $scope.patientview)
        {
            if (($scope.patientview[x].patient_id) == ida)
            {
                $scope.editshowflag = true;
                $scope.ed_title = $scope.patientview[x].title;
                $scope.ed_name = $scope.patientview[x].first_name;
                $scope.ed_date = $scope.patientview[x].birthdate;
                $scope.ed_age = $scope.patientview[x].age;
                $scope.ed_address = $scope.patientview[x].address_1;
                $scope.ed_email = $scope.patientview[x].email;
                $scope.ed_sex = $scope.patientview[x].gender;
                $scope.ed_company = $scope.patientview[x].company;
                $scope.ed_meeting = $scope.patientview[x].meeting;
                $scope.ed_facebook = $scope.patientview[x].facebook;
                $scope.ed_note = $scope.patientview[x].note;
                $scope.ed_mobile = $scope.patientview[x].phone;
                $scope.edpatient_id = $scope.patientview[x].patient_id;

                $scope.check = 1;
            }
        }
    };
    //eyedis  
    $http.get("eyedis")
            .then(function (response) {
                $scope.eyedisdata = response.data.eye_diseases;
            });
    $http.get("eyedis?req=cat")
            .then(function (response) {
                $scope.eyediscat = response.data.eye_diseases;
            });

    //cordis  
    $http.get("cordis")
            .then(function (response) {
                $scope.cordisdata = response.data.chronic_disease;
            });


    //report
    $http.get("report")
            .then(function (response) {
                $scope.reportdata = response.data.report;

            });

    //patients
    $scope.patientview = "";
    $http.get("patient")
            .then(function (response) {
                $scope.patientview = response.data.patient;
            });


    //filters 
    $scope.disbycat = function (item) {
        if ($scope.rescatdisease == null || $scope.rescatdisease == "null")
            return true;
        return item.cat == $scope.rescatdisease;
    };
    $scope.select = function (item) {
        if ($scope.selectedpatient == null)
            return true;

        return item.first_name.indexOf($scope.selectedpatient) !== -1;
    };


    $scope.curebycat = function (item) {
        if ($scope.resCureCategory == null || $scope.resCureCategory == "null")
            return true;
        return item.catregory == $scope.resCureCategory;
    };

    $scope.edittt = function (item) {
        return item.patient_id == $scope.currentid;
    };


    $scope.formatbycure = function (item) {

        return item.describtion == $scope.rescure;

    };
    
//reception
    $scope.reception = [];
    $scope.recepedit = function (ida) {
        var check=true;
        for(y in $scope.reception)
        {
            if($scope.reception[y].id==ida)
            {
                check = false;
                alert("This Patient is already added to your reception");
                break;
            }
        }
        
        for (x in $scope.patientview)
        {
            if (($scope.patientview[x].patient_id) == ida&&check)
            {
                var line = {
                    "name": $scope.patientview[x].first_name,
                    "address": $scope.patientview[x].address_1,
                    "age": $scope.patientview[x].age,
                    "phone": $scope.patientview[x].phone,
                    "id": $scope.patientview[x].patient_id
                };
                $scope.reception.push(line);
            }
        }
    };

//add line in pres
    $scope.prelines = [];
    $scope.apply = function () {
        var line = {
            "cure": $scope.rescure,
            "format": $scope.rescureformat,
            "times": $scope.pretimes,
            "Duration": $scope.preduration,
            "Amount": $scope.preamount,
            "place": $scope.preplace,
            "note": $scope.prenote
        }
        $scope.prelines.push(line);

        $scope.rescure = null;
        $scope.rescureformat = null;
        $scope.pretimes = null;
        $scope.preduration = null;
        $scope.preamount = null;
        $scope.preplace = null;
        $scope.prenote = null;
    };
    
//edit patient
    $scope.editpat = function () {
        $scope.editshowflag = false;
        return $http.post("editpatient",
                {
                    "name": $scope.ed_name,
                    "age": $scope.ed_age,
                    "sex": $scope.ed_sex,
                    "email": $scope.ed_email,
                    "mobile": $scope.ed_mobile,
                    "address": $scope.ed_address,
                    "note": $scope.ed_note,
                    "year": $scope.ed_date,
                    "title": $scope.ed_title,
                    "meeting": $scope.ed_meeting,
                    "company": $scope.ed_company,
                    "facebook": $scope.ed_facebook,
                    "patId": $scope.edpatient_id
                })
                .then(function (response) {
                    $http.get("patient")
                            .then(function (response) {
                                $scope.patientview = response.data.patient;
                            });
                    return response;
                });

    };

    //new patinet 
    $scope.newpat = function () {

        return $http.post("patient",
                {name: $scope.pat.name,
                    age: $scope.pat.age,
                    sex: $scope.pat.sex,
                    email: $scope.pat.email,
                    mobile: $scope.pat.mobile,
                    address: $scope.pat.address,
                    note: $scope.pat.note,
                    year: $scope.pat.date,
                    title: $scope.pat.title,
                    meeting: $scope.pat.meeting,
                    company: $scope.pat.company,
                    facebook: $scope.pat.facebook
                })
                .then(function (response) {
                    return response;
                });
    };
}); 