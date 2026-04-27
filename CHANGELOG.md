# Changelog

## 0.13.0 (2026-04-27)

Full Changelog: [v0.12.0...v0.13.0](https://github.com/rye-com/checkout-intents-java/compare/v0.12.0...v0.13.0)

### Features

* Expose `retailer` field ([5442465](https://github.com/rye-com/checkout-intents-java/commit/5442465b80abc1ba6d907ca1589a506b6af3742a))

## 0.12.0 (2026-04-23)

Full Changelog: [v0.11.0...v0.12.0](https://github.com/rye-com/checkout-intents-java/compare/v0.11.0...v0.12.0)

### Features

* **api:** add new data field to event type ([51574b1](https://github.com/rye-com/checkout-intents-java/commit/51574b1bf629d848a1e7377f42a93d8ca95e7a62))

## 0.11.0 (2026-04-22)

Full Changelog: [v0.10.0...v0.11.0](https://github.com/rye-com/checkout-intents-java/compare/v0.10.0...v0.11.0)

### Features

* Add `webhook_endpoint.verification_challenge` event type ([15641f6](https://github.com/rye-com/checkout-intents-java/commit/15641f6df0035b2cd4417b67e7284014ef808a3a))
* Add events endpoints ([fbeaaf2](https://github.com/rye-com/checkout-intents-java/commit/fbeaaf2933500d3ffe6a4e23fa94731f98b21a51))
* **api:** add events endpoints ([f5c7617](https://github.com/rye-com/checkout-intents-java/commit/f5c761762b0696d799fa57ddaf19d94d8de1f713))


### Chores

* **internal:** improvements ([106ca4e](https://github.com/rye-com/checkout-intents-java/commit/106ca4e2adf4aa09ac62b5d056eb056e28db3d87))

## 0.10.0 (2026-04-14)

Full Changelog: [v0.9.0...v0.10.0](https://github.com/rye-com/checkout-intents-java/compare/v0.9.0...v0.10.0)

### Features

* Add clearer product-not-found error for ASIN 404s ([0f922de](https://github.com/rye-com/checkout-intents-java/commit/0f922de15b161dfe57622d4f469ff38421b2be5e))
* **api:** manual updates ([ea278a0](https://github.com/rye-com/checkout-intents-java/commit/ea278a05c656fc2e0903fbcfb6b55179a5f6c1c7))
* **api:** manual updates ([f59a4d2](https://github.com/rye-com/checkout-intents-java/commit/f59a4d22377455e620d05a4fdd42ba3deda3bd53))
* **billing:** add DELETE /billing/drawdown/topup/:invoiceId endpoint ([970fb36](https://github.com/rye-com/checkout-intents-java/commit/970fb360c9aa58541bd97aaae7b02f4b082a5504))
* **billing:** add self-serve drawdown billing setup endpoints ([61bb27c](https://github.com/rye-com/checkout-intents-java/commit/61bb27c70402dd51178da21d335f94ed14b06ca3))
* Fix TSOA spec generation by adding ci-billing path mapping ([0e693b0](https://github.com/rye-com/checkout-intents-java/commit/0e693b04253aed2e3bca37ffda4e0cbb2bb39783))
* Gate x402 payments behind Hypertune feature flag ([a57e59d](https://github.com/rye-com/checkout-intents-java/commit/a57e59d65642cc47cc3ca565f1b4d9f4451d3e70))

## 0.9.0 (2026-04-01)

Full Changelog: [v0.8.0...v0.9.0](https://github.com/rye-com/checkout-intents-java/compare/v0.8.0...v0.9.0)

### Features

* RYE-7142: Add shipment status to individual tracking events ([de11c3a](https://github.com/rye-com/checkout-intents-java/commit/de11c3a5d8977526a52bd9df29d65b8f132de606))

## 0.8.0 (2026-03-28)

Full Changelog: [v0.7.2...v0.8.0](https://github.com/rye-com/checkout-intents-java/compare/v0.7.2...v0.8.0)

### Features

* Add payment gateway to stainless.yml ([0e59a76](https://github.com/rye-com/checkout-intents-java/commit/0e59a7654b717fd1c37c59a8feddf29930f521f5))

## 0.7.2 (2026-03-27)

Full Changelog: [v0.7.1...v0.7.2](https://github.com/rye-com/checkout-intents-java/compare/v0.7.1...v0.7.2)

### Chores

* **ci:** skip lint on metadata-only changes ([a4860c9](https://github.com/rye-com/checkout-intents-java/commit/a4860c901196b89a6d781ff5b13ad167087a8ef6))
* **internal:** improvements ([7ac7071](https://github.com/rye-com/checkout-intents-java/commit/7ac707168431b13d5ad7fe1e2ad0ae6e89a076c4))
* **internal:** update gitignore ([908efa2](https://github.com/rye-com/checkout-intents-java/commit/908efa2f83fc92630f1b2884198994e9daa05c27))

## 0.7.1 (2026-03-23)

Full Changelog: [v0.7.0...v0.7.1](https://github.com/rye-com/checkout-intents-java/compare/v0.7.0...v0.7.1)

### Bug Fixes

* **api:** use repeat format for array query param serialization ([2291903](https://github.com/rye-com/checkout-intents-java/commit/2291903323bc72909c725ad14ff5bddf105fde4c))


### Chores

* **internal:** bump ktfmt ([f81e249](https://github.com/rye-com/checkout-intents-java/commit/f81e249da70cf6387583160cf1d8d017c25a817f))

## 0.7.0 (2026-03-20)

Full Changelog: [v0.6.0...v0.7.0](https://github.com/rye-com/checkout-intents-java/compare/v0.6.0...v0.7.0)

### Features

* Add deliveryEstimate to shipping options in offers. ([75b844e](https://github.com/rye-com/checkout-intents-java/commit/75b844e98bdcb3882a4ab57ca175697a6ec6ab53))

## 0.6.0 (2026-03-18)

Full Changelog: [v0.5.0...v0.6.0](https://github.com/rye-com/checkout-intents-java/compare/v0.5.0...v0.6.0)

### Features

* Return 403 for non-drawdown developers on billing endpoints ([69978e8](https://github.com/rye-com/checkout-intents-java/commit/69978e8d0c4b9c1d5fa5f9585937ac347ca51919))
* Update shipment types in prep for tracking updates ([dc53e25](https://github.com/rye-com/checkout-intents-java/commit/dc53e2525772e34bc18deb0a019ed09493616e96))


### Bug Fixes

* **client:** allow updating header/query affecting fields in `toBuilder()` ([062a87f](https://github.com/rye-com/checkout-intents-java/commit/062a87f3be445e794e7c3e0a35389e374ec42fbd))
* **client:** incorrect `Retry-After` parsing ([e604a5b](https://github.com/rye-com/checkout-intents-java/commit/e604a5b5b3aa5ceb05bd2b2f4434479d4daf17ae))
* **docs:** remove double-slash from server urls ([5d76a93](https://github.com/rye-com/checkout-intents-java/commit/5d76a93027103bc18f8a2c82e7b7f017760456c4))


### Chores

* **ci:** skip uploading artifacts on stainless-internal branches ([e593355](https://github.com/rye-com/checkout-intents-java/commit/e5933550c9198838f574b7ce72f9a0509caf3543))
* **docs:** improve examples ([ccf9df3](https://github.com/rye-com/checkout-intents-java/commit/ccf9df3bb460fd688d8a13af9bb777bf3fe37334))
* **internal:** tweak CI branches ([99e9121](https://github.com/rye-com/checkout-intents-java/commit/99e91219cb069c2de2bcf70ca32c494f3fc1965f))
* **internal:** update retry delay tests ([2eaba98](https://github.com/rye-com/checkout-intents-java/commit/2eaba987f50ddc47064d580a51c810b889b735cd))

## 0.5.0 (2026-03-06)

Full Changelog: [v0.4.1...v0.5.0](https://github.com/rye-com/checkout-intents-java/compare/v0.4.1...v0.5.0)

### Features

* Add variant models to Stainless SDK config ([495a420](https://github.com/rye-com/checkout-intents-java/commit/495a420eaf8e18f20354d133bdd11de4cebf54ea))
* add variant types and wire through extraction pipeline (RYE-6876) ([a88692b](https://github.com/rye-com/checkout-intents-java/commit/a88692b88db64238f0d2b4696d73f2e01afc44c6))
* Cut 1x Firestore read from offer retrieval ([ef8dc0b](https://github.com/rye-com/checkout-intents-java/commit/ef8dc0b5d531e4d52a7c025eb552a71acf0560a3))
* expose Shopify variants and extract ProductGroup variants from JSON-LD (RYE-6878) ([c2f45aa](https://github.com/rye-com/checkout-intents-java/commit/c2f45aa577c3348b75a74d8429bc07e8e351780c))
* rename ProductVariant.attributes to dimensions ([a92c28b](https://github.com/rye-com/checkout-intents-java/commit/a92c28b801266093a24279d77af77f2dfdacfeb8))


### Bug Fixes

* handle [@type](https://github.com/type) array and AggregateOffer array in JSON-LD parser ([4256ba4](https://github.com/rye-com/checkout-intents-java/commit/4256ba4c2c614ea8376e4da16d2536fdb7eba1c8))
* **internal:** formatting ([e693b89](https://github.com/rye-com/checkout-intents-java/commit/e693b89a9260ea5746fa53cc42e6dfd1267f1a48))
* rename VariantDimension.name to label for consistency with VariantSelection ([09e7c5f](https://github.com/rye-com/checkout-intents-java/commit/09e7c5fa41465e7a8503c8b99d4cba01987df6e2))


### Chores

* **internal:** bump palantir-java-format ([32cb5c9](https://github.com/rye-com/checkout-intents-java/commit/32cb5c96593d0588575919e9e82b888cade500b8))
* **internal:** codegen related update ([c4faf24](https://github.com/rye-com/checkout-intents-java/commit/c4faf24f6f7cdea7574072014e994de8147dddc7))
* **internal:** improvements ([b396721](https://github.com/rye-com/checkout-intents-java/commit/b396721eb8599a7ebe9ba9342770839674713283))

## 0.4.1 (2026-02-28)

Full Changelog: [v0.4.0...v0.4.1](https://github.com/rye-com/checkout-intents-java/compare/v0.4.0...v0.4.1)

### Chores

* **internal:** improvements ([ffa4360](https://github.com/rye-com/checkout-intents-java/commit/ffa43601e5702847d22f7e87e35a2a844a3fd402))

## 0.4.0 (2026-02-27)

Full Changelog: [v0.3.0...v0.4.0](https://github.com/rye-com/checkout-intents-java/compare/v0.3.0...v0.4.0)

### Features

* Add hidden billing API endpoints for drawdown balance and transactions ([bff6f21](https://github.com/rye-com/checkout-intents-java/commit/bff6f215eca87901197630b7c52862994e531727))
* Added new shipments endpoint for tracking Amazon orders ([9cdd369](https://github.com/rye-com/checkout-intents-java/commit/9cdd3690b379fdebd5e71b7f0265551dd0a5c167))
* proxy product images through Rye domain ([18c28fd](https://github.com/rye-com/checkout-intents-java/commit/18c28fd4392a36d4561e1fb1589bcce99948bd57))
* Store estimated delivery date on completed checkout intent ([b88a66a](https://github.com/rye-com/checkout-intents-java/commit/b88a66adb4dafbf8d466e987a482de3ce17df2a8))


### Bug Fixes

* **internal:** formatting ([06999cb](https://github.com/rye-com/checkout-intents-java/commit/06999cba028a2a5136a514c3fb3c059bb682ba0b))


### Chores

* drop apache dependency ([c36e23e](https://github.com/rye-com/checkout-intents-java/commit/c36e23ee1b6972835d2c603982d3728a94994e7b))
* **internal:** expand imports ([393502d](https://github.com/rye-com/checkout-intents-java/commit/393502d8d77d4c30c12e0173386056c1118ab1d8))
* **internal:** improvements ([9845b45](https://github.com/rye-com/checkout-intents-java/commit/9845b456019ac052089e5d9e948f21acdb03b48d))
* make `Properties` more resilient to `null` ([993d946](https://github.com/rye-com/checkout-intents-java/commit/993d946d8be260a0a22a91251c739f049adfab29))

## 0.3.0 (2026-02-23)

Full Changelog: [v0.2.1...v0.3.0](https://github.com/rye-com/checkout-intents-java/compare/v0.2.1...v0.3.0)

### Features

* add merchants API endpoint ([12f99f9](https://github.com/rye-com/checkout-intents-java/commit/12f99f9a7b66686050f0c7e88e2aa24f1346b4d4))
* Add PaymentMethod support for Prava ([ae6d6cb](https://github.com/rye-com/checkout-intents-java/commit/ae6d6cb511cb99356f8ece3701992e54d8177b8a))
* Add stainless updates ([fb0f075](https://github.com/rye-com/checkout-intents-java/commit/fb0f075ef6a3e09e80120f3731237153dd01e207))
* Billing: Add BillingReconciliationService for expired drawdown orders ([d3a3855](https://github.com/rye-com/checkout-intents-java/commit/d3a385579eecd5a24d4a8f808c2c1e48801d394b))
* Billing: Envelope payment processing fields ([72d18b0](https://github.com/rye-com/checkout-intents-java/commit/72d18b0637dd2fad04f26c1a7675c13b7163b697))
* Billing: Integrate drawdown payments in order flow ([7029b35](https://github.com/rye-com/checkout-intents-java/commit/7029b3574ebd60646607851a5e8e203b2a815bef))
* Centralize Shopify domain resolution into ShopifyDomainResolver service ([2053e4f](https://github.com/rye-com/checkout-intents-java/commit/2053e4f55e472bc230b748dabf3dcb2631358965))
* **client:** add connection pooling option ([d7faa58](https://github.com/rye-com/checkout-intents-java/commit/d7faa5878327d0b74dd9f7120b6e581c427db31a))
* Enable searching checkoutIntent by order Id on dev console ([534be19](https://github.com/rye-com/checkout-intents-java/commit/534be1973cdab9b6d5ea8fe329572e4082597cf2))
* integrate promo codes discovery to checkout intent flow ([f9395c5](https://github.com/rye-com/checkout-intents-java/commit/f9395c53d322d83e964b02bade7829a3809ddd52))
* Phase 3: Strategy Interface + Normalizer ([0d545d4](https://github.com/rye-com/checkout-intents-java/commit/0d545d4091b5b12ec83818fa15021265d9f81dad))
* Remove `shipments` from our stainless config ([e5f9bec](https://github.com/rye-com/checkout-intents-java/commit/e5f9bec1c262ee7d0669317a1f3b95ff5896ac7e))
* Remove duplicate method from controller ([9980917](https://github.com/rye-com/checkout-intents-java/commit/9980917a7b24a1e4e5fc37cee4aebee2ac898ccb))
* Unwrap `rd.bizrate.com` affiliate URLs ([d835fa0](https://github.com/rye-com/checkout-intents-java/commit/d835fa0fe51c6fa432f1a1ef638ad03f1c13d212))
* Update return states to better reflect return lifecycle ([ff88f7f](https://github.com/rye-com/checkout-intents-java/commit/ff88f7f9e1a22dc69f47069ecd7cdcb5de1411bf))
* wire up wizard layout and pass layout type through JWT ([0277eb6](https://github.com/rye-com/checkout-intents-java/commit/0277eb6c2196c0a86327889065f87ba7fc67ab6f))


### Chores

* **internal:** allow passing args to `./scripts/test` ([9922d19](https://github.com/rye-com/checkout-intents-java/commit/9922d19e736cab224da2dd0f1f30c96fed8da985))
* **internal:** improvements ([095494e](https://github.com/rye-com/checkout-intents-java/commit/095494ee6a943e8dab283c17e2b8b2953373cf7f))
* **internal:** improvements ([6e2347f](https://github.com/rye-com/checkout-intents-java/commit/6e2347fd839e359c4a8ac523ad5bc3f8e9d47ac2))
* **internal:** improvements ([441a859](https://github.com/rye-com/checkout-intents-java/commit/441a859fb471f3ba10c556b1077bef4d630b3085))
* **internal:** make `OkHttp` constructor internal ([fb67eeb](https://github.com/rye-com/checkout-intents-java/commit/fb67eeb647c0a70c9f49d7e1a9281bbd4488448d))
* **internal:** remove mock server code ([f43dd50](https://github.com/rye-com/checkout-intents-java/commit/f43dd50bfe1bdeb8e8e298d449960b37607c4237))
* **internal:** update `TestServerExtension` comment ([4771bb0](https://github.com/rye-com/checkout-intents-java/commit/4771bb0c7d080e594889a74a9a5f2f8705533048))
* **internal:** upgrade AssertJ ([b06bd05](https://github.com/rye-com/checkout-intents-java/commit/b06bd05688fda0a5e1fade045b8fdfe66f4f44a9))
* update mock server docs ([e1ab598](https://github.com/rye-com/checkout-intents-java/commit/e1ab5984bb885d1c9f7b10064390ef94556c438a))

## 0.2.1 (2026-01-30)

Full Changelog: [v0.2.0...v0.2.1](https://github.com/rye-com/checkout-intents-java/compare/v0.2.0...v0.2.1)

### Chores

* **docs:** rename "retrieve product" to "lookup product" ([2a02ee1](https://github.com/rye-com/checkout-intents-java/commit/2a02ee1a0a73c30cf4a721542a6fd768bf6ab932))

## 0.2.0 (2026-01-30)

Full Changelog: [v0.1.0...v0.2.0](https://github.com/rye-com/checkout-intents-java/compare/v0.1.0...v0.2.0)

### Features

* **api:** introduce lookup product data endpoint ([c864f57](https://github.com/rye-com/checkout-intents-java/commit/c864f5760eec2abe91ca2c4b2d72b32a547c203b))
* Implement shipping profile -&gt; shipping option calculation ([ffad9b7](https://github.com/rye-com/checkout-intents-java/commit/ffad9b7342ff084b75db948bdbec180986f5907d))


### Chores

* **ci:** upgrade `actions/github-script` ([bd8f824](https://github.com/rye-com/checkout-intents-java/commit/bd8f824bede3eb8d1718b9bdf28f8f9ce254cdff))
* **internal:** rename `Product` type ([0917d5c](https://github.com/rye-com/checkout-intents-java/commit/0917d5cadc84292c6f56c2f2460d1ec59e935347))

## 0.1.0 (2026-01-24)

Full Changelog: [v0.0.3...v0.1.0](https://github.com/rye-com/checkout-intents-java/compare/v0.0.3...v0.1.0)

### Features

* **api:** auto infer env from user provided api key ([63e7893](https://github.com/rye-com/checkout-intents-java/commit/63e78939b4a72900b42a933d3be2e1e813e7eba8))
* **api:** polling exception and option classes ([e21f6f3](https://github.com/rye-com/checkout-intents-java/commit/e21f6f38054670b9dd28ef0537eccbd9d57bee3b))
* **api:** polling exception and option classes ([2d7d1ba](https://github.com/rye-com/checkout-intents-java/commit/2d7d1bafc5d4bcc27f36e854e3fd15e3de96d6ea))
* **api:** polling helpers ([a93bdb4](https://github.com/rye-com/checkout-intents-java/commit/a93bdb4e4f38b07a033438d3069384f55bec9a0c))
* **api:** polling helpers ([2e59621](https://github.com/rye-com/checkout-intents-java/commit/2e59621e13aa4c3859fa735a4dc451a1669f0e2c))


### Chores

* **api:** polling helper tests ([4718564](https://github.com/rye-com/checkout-intents-java/commit/471856453e4885558c857875cfa0313c50bfdf78))
* **api:** polling helper tests ([87238d8](https://github.com/rye-com/checkout-intents-java/commit/87238d8c76d4cb417a01f8052bf16e5b8a06a73c))
* **internal:** run formatting ([f977e63](https://github.com/rye-com/checkout-intents-java/commit/f977e63e70109d0a1385e75db8ac03027d3b71c0))
* **internal:** run formatting ([ac7d901](https://github.com/rye-com/checkout-intents-java/commit/ac7d90188bd7ffec15455f0a3dc0e60ff9583d9d))
* sync repo ([3b8c55a](https://github.com/rye-com/checkout-intents-java/commit/3b8c55a2bba1e3051d2c2e39f971982767446cad))


### Documentation

* **api:** add polling helper details ([5ac1240](https://github.com/rye-com/checkout-intents-java/commit/5ac124075403ac95669d4aa7f6b4458b2bb97f1a))
* **api:** add polling helper details ([21281c7](https://github.com/rye-com/checkout-intents-java/commit/21281c736cd6e1389d0425c751116e78bcd7d00e))
* **api:** update polling example ([3333fb0](https://github.com/rye-com/checkout-intents-java/commit/3333fb07621165553e8a2b74adceb74f4a6e79e3))
* **api:** update polling example ([8489612](https://github.com/rye-com/checkout-intents-java/commit/84896126ae17875945033b3df05ba087ea525195))

## 0.0.3 (2026-01-22)

Full Changelog: [v0.0.2...v0.0.3](https://github.com/rye-com/checkout-intents-java/compare/v0.0.2...v0.0.3)

### Chores

* **internal:** config ([f37dc61](https://github.com/rye-com/checkout-intents-java/commit/f37dc61ce42093f94dcff36e870acb44dc202be1))
* **internal:** remove redundant project dirs ([d323332](https://github.com/rye-com/checkout-intents-java/commit/d3233327f446831cfdf411f64e3abde2f713473e))
* sync repo ([ad7c40d](https://github.com/rye-com/checkout-intents-java/commit/ad7c40d9ddcd9d476bd811ea1fa641091636684f))
* update SDK settings ([77837a5](https://github.com/rye-com/checkout-intents-java/commit/77837a5ad58ab45bb39353e2adca6e19b9164280))

## 0.0.2 (2026-01-22)

Full Changelog: [v0.0.1...v0.0.2](https://github.com/rye-com/checkout-intents-java/compare/v0.0.1...v0.0.2)

### Chores

* configure new SDK language ([7b74b90](https://github.com/rye-com/checkout-intents-java/commit/7b74b90e03ff94ab2aa9a83a3f6bde2cde29e5d2))
* update SDK settings ([62365c7](https://github.com/rye-com/checkout-intents-java/commit/62365c71ae0e29e22cf2ce84c2e31f278fb7bc4b))
