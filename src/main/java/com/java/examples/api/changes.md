# What changed in api

* Combined AddAssociateApi and GetAssociateApi into AssociateApi
* Changed ids field to associateCache since it is a better name for what's being done
* Changed getAssociate from PostMapping to GetMapping since it's retrieving an associate resource
* Changed addAssociate from PatchMapping to PostMapping since it's a newly added resource
* Changed URL for getAssociate to /api/associate/{id} rather than /api/getAssociate
* Changed URL for addAssociate to /api/associate rather than /api/addAssociate
* Removed @RequestParam String id from the addAssociate signature
* Changed @RequestParam (e.g. ?id={id}) to @PathVariable (e.g. /{id}) for both addAssociate and getAssociate
* Added `@GetMapping(value="/api/getAssociate")` to getAssociates method
* Returned List<Associate> on getAssociates method rather than generic List with cast
* Changed getAssociates to return new ArrayList<>(ids.values)
* 
