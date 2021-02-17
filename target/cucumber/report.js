$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('Feature\purchase.feature');
formatter.feature({
  "line": 1,
  "name": "Toypurchase",
  "description": "",
  "id": "toypurchase",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Purchase a toy",
  "description": "",
  "id": "toypurchase;purchase-a-toy",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@purchase"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "I open guru99 website",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enters valid data details on the page",
  "rows": [
    {
      "cells": [
        "Fields",
        "values"
      ],
      "line": 6
    },
    {
      "cells": [
        "Quantity",
        "2"
      ],
      "line": 7
    },
    {
      "cells": [
        "card_nmuber",
        "7493037578241902"
      ],
      "line": 8
    },
    {
      "cells": [
        "month",
        "02"
      ],
      "line": 9
    },
    {
      "cells": [
        "year",
        "2022"
      ],
      "line": 10
    },
    {
      "cells": [
        "cvv_code",
        "989"
      ],
      "line": 11
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "payment should be done",
  "keyword": "Then "
});
formatter.match({
  "location": "PurchaseToy.go_To_guru99()"
});
formatter.result({
  "duration": 15792373601,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseToy.enter_Data(DataTable)"
});
formatter.result({
  "duration": 17577540000,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseToy.payment_Successful()"
});
formatter.result({
  "duration": 634589600,
  "status": "passed"
});
});