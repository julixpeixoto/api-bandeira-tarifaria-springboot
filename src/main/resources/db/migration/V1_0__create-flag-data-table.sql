CREATE TABLE IF NOT EXISTS flag_data (
    id VARCHAR(36) NOT NULL,
    year_number VARCHAR(4) NOT NULL,
    flag VARCHAR(50) NOT NULL,
    month_text VARCHAR(10) NOT NULL,
    month_number SMALLINT NOT NULL,
    factor VARCHAR(10) NOT NULL,
    created_at timestamp NOT NULL default CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);