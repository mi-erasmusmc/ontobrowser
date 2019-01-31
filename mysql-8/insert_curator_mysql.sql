-- Copyright 2015 Novartis Institutes for Biomedical Research
-- 
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- 
--     http://www.apache.org/licenses/LICENSE-2.0
-- 
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.

-- WHENEVER SQLERROR EXIT FAILURE ROLLBACK
-- WHENEVER OSERROR EXIT FAILURE ROLLBACK
-- SET SHOW OFF
-- SET TERMOUT OFF
-- SET FEEDBACK OFF
-- SET ECHO OFF
-- SET VERIFY OFF
INSERT INTO CURATOR (
  CURATOR_ID, 
  USERNAME, 
  IS_ACTIVE, 
  CREATED_BY) 
VALUES (
  2, 
  '&1',
  1, 
  1);

INSERT INTO CURATOR_APPROVAL_WEIGHT (
  CURATOR_APPROVAL_ID,
  CURATOR_ID,
  TABLE_NAME,
  APPROVAL_WEIGHT,
  CREATED_BY)
VALUES (
  3, 
  15, 
  'TERM',
  1, 
  1);
  
INSERT INTO CURATOR_APPROVAL_WEIGHT (
  CURATOR_APPROVAL_ID,
  CURATOR_ID,
  TABLE_NAME,
  APPROVAL_WEIGHT,
  CREATED_BY)
VALUES (
  4, 
  15, 
  'TERM_SYNONYM',
  1.0, 
  1);
  
INSERT INTO CURATOR_APPROVAL_WEIGHT (
  CURATOR_APPROVAL_ID,
  CURATOR_ID,
  TABLE_NAME,
  APPROVAL_WEIGHT,
  CREATED_BY)
VALUES (
  5, 
  15, 
  'TERM_RELATIONSHIP',
  1.0, 
  1);
COMMIT;
-- EXIT SUCCESS