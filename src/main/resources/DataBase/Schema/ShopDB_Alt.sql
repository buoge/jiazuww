/*
ALTER TABLE table_name ADD column_name column-definition;
ALTER TABLE `workorder`
ADD `discount` tinyint DEFAULT NULL after saleorder_id,
ADD `note` varchar(254) DEFAULT NULL after discount;
*/