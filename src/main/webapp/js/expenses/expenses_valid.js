/**
 * chrisryo
 */
var expensesValid = function() {
  return {

    condition1: function() {
      var valid = [{
        name: "billDate",
        rule: "validate[custom[date]]",
        maxlength: 10
      }, {
        name: "source",
        rule: "validate[maxSize[20]]",
        maxlength: 20
      }, {
        name: "billStore",
        rule: "validate[maxSize[1]]",
        maxlength: 1
      }, {
        name: "realTotalAmt",
        rule: "validate[custom[number]], max[999999999999999]",
        maxlength: 18
      }];

      return valid;
    },

    condition2: function() {
      var valid = [{
        name: "realDate",
        rule: "validate[custom[date], required]",
        maxlength: 10
      }, {
        name: "realStore",
        rule: "validate[maxSize[1], required]",
        maxlength: 1
      }, {
        name: "accountIteam",
        rule: "validate[maxSize[20]]",
        maxlength: 20
      }, {
        name: "detail",
        rule: "validate[maxSize[60]]",
        maxlength: 60
      }, {
        name: "payeeUnit",
        rule: "validate[maxSize[1], required]",
        maxlength: 1
      }, {
        name: "payee",
        rule: "validate[maxSize[20]]",
        maxlength: 20
      }, {
        name: "workTime",
        rule: "validate[maxSize[20]]",
        maxlength: 20
      }, {
        name: "workType",
        rule: "validate[validate[custom[number]], maxSize[1]], validate[max[9]]",
        maxlength: 1
      }, {
        name: "price",
        rule: "validate[custom[number]], max[999999999999999]",
        maxlength: 18
      }, {
        name: "quantity",
        rule: "validate[custom[number]], max[999999999999999]",
        maxlength: 18
      }, {
        name: "unit",
        rule: "validate[maxSize[20]]",
        maxlength: 20
      }, {
        name: "amt",
        rule: "validate[custom[number]], max[999999999999999]",
        maxlength: 18
      }, {
        name: "mark",
        rule: "validate[maxSize[60]]",
        maxlength: 60
      }];

      return valid;
    },
  }
}();