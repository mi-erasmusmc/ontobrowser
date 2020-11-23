-- The original create_schema files contains places unique constraints on several keys in many to one relationships,
-- this fixes that issue. As at present I am not sure on whether we will rebuild the entire DB upon next deployment,
-- I'm putting this in an additional file rather than changing the create_schema file.


-- Need to create an index first, otherwise FK will not allow unique to be dropped
ALTER TABLE `CTRLD_VOCAB`
    ADD INDEX (`DATASOURCE_ID`);
ALTER TABLE `CTRLD_VOCAB`
    DROP INDEX `DATASOURCE_ID_UNIQUE`;

ALTER TABLE `CTRLD_VOCAB_TERM`
    ADD INDEX (`CTRLD_VOCAB_ID`);
ALTER TABLE `CTRLD_VOCAB_TERM`
    DROP INDEX `CTRLD_VOCAB_ID_UNIQUE`;