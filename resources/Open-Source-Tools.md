# Open-Source Data Engineering Tools

A quick reference to the main open-source projects in the modern data stack: what each one does and when you'd reach for it.
"ASF" means the project is run by the Apache Software Foundation.

## Table Formats (Lakehouse) → [04-Data-Lakehouse](../04-Data-Lakehouse/)

| Project | Backed by | What it does | Use when |
|---|---|---|---|
| [Apache Iceberg](https://iceberg.apache.org) | ASF | Open table format: ACID, schema & partition evolution, hidden partitioning, time travel, snapshot isolation | You want an engine-agnostic lakehouse (Spark, Trino, Flink, Snowflake, Athena all read it) |
| [Apache Hudi](https://hudi.apache.org) | ASF | Table format built for upserts/deletes and incremental pulls; Copy-on-Write and Merge-on-Read tables | Lots of updates/CDC into the lake, near-real-time ingestion |
| [Delta Lake](https://delta.io) | Linux Foundation | Transaction-log-based table format, tightly integrated with Spark/Databricks | You're on Spark or Databricks |
| [Apache Paimon](https://paimon.apache.org) | ASF | Streaming lakehouse format (LSM-tree based), born out of Flink | Streaming-first lakehouse with Flink |
| [Apache XTable](https://xtable.apache.org) | ASF (incubating) | Translates metadata between Iceberg, Hudi, and Delta | Interoperability between formats |

## Query Engines & OLAP → [04-Data-Lakehouse/Trino](../04-Data-Lakehouse/Trino/)

| Project | Backed by | What it does | Use when |
|---|---|---|---|
| [Trino](https://trino.io) | Trino Software Foundation | Distributed MPP SQL engine that federates queries across many sources (Hive, Iceberg, Postgres, Kafka…) | Interactive SQL over a data lake, or joins across systems |
| [Presto](https://prestodb.io) | Linux Foundation | The original engine Trino forked from (Meta) | Existing Presto deployments |
| [Apache Spark](https://spark.apache.org) | ASF | General distributed compute: batch, SQL, streaming, ML | Heavy ETL and large-scale transformations |
| [Apache Flink](https://flink.apache.org) | ASF | Stateful stream processing with exactly-once semantics and event time | True low-latency streaming |
| [Apache Doris](https://doris.apache.org) | ASF | Real-time MPP analytical database | Sub-second dashboards on fresh data |
| [StarRocks](https://www.starrocks.io) | Linux Foundation | MPP OLAP database (forked from Doris); can also query lakehouse tables directly | Fast OLAP and lakehouse acceleration |
| [ClickHouse](https://clickhouse.com) | ClickHouse Inc. | Columnar OLAP database, extremely fast aggregations | Logs, events, and analytics at scale |
| [Apache Druid](https://druid.apache.org) / [Apache Pinot](https://pinot.apache.org) | ASF | Real-time OLAP stores for user-facing analytics | High-concurrency, low-latency queries |
| [DuckDB](https://duckdb.org) | DuckDB Foundation | In-process analytical database ("SQLite for analytics") | Local analysis of Parquet/CSV files, small-to-medium data |

## Data Integration / Ingestion

| Project | Backed by | What it does | Use when |
|---|---|---|---|
| [Apache SeaTunnel](https://seatunnel.apache.org) | ASF | High-performance data integration with 100+ connectors; runs batch and streaming; ships its own Zeta engine and can also run on Spark or Flink | Bulk sync between DBs, the lake, and the warehouse, including CDC sources |
| [Apache NiFi](https://nifi.apache.org) | ASF | Flow-based data routing with a visual UI and data provenance | Many small flows, IoT, routing and enrichment |
| [Airbyte](https://airbyte.com) | Airbyte Inc. | ELT platform with a large connector catalog | SaaS/API → warehouse ingestion |
| [Apache InLong](https://inlong.apache.org) | ASF | One-stop ingestion and distribution for massive data | Large-scale ingestion pipelines |
| [Kafka Connect](https://kafka.apache.org/documentation/#connect) | ASF | Framework for source/sink connectors running on Kafka | Moving data in and out of Kafka |
| [dlt](https://dlthub.com) | dltHub | Python library for building EL pipelines | Code-first ingestion in Python |

## CDC (Change Data Capture) → [03-Data-Streaming/CDC](../03-Data-Streaming/CDC/)

| Project | Backed by | Sources | What it does | Use when |
|---|---|---|---|---|
| [Debezium](https://debezium.io) | Red Hat / Commonhaus | MySQL, Postgres, MongoDB, SQL Server, Oracle, Db2, Cassandra… | Log-based CDC as Kafka Connect source connectors; also available as Debezium Server (no Kafka needed) or embedded | The default choice for CDC into Kafka |
| [Maxwell](https://maxwells-daemon.io) | Zendesk (OSS) | MySQL only | Reads the MySQL binlog and emits row changes as JSON to Kafka, Kinesis, RabbitMQ, Redis, and more; lightweight, with bootstrapping support | Simple MySQL → Kafka CDC without Kafka Connect |
| [Canal](https://github.com/alibaba/canal) | Alibaba | MySQL | Binlog parser that pretends to be a MySQL replica | MySQL CDC, popular in China-based stacks |
| [Flink CDC](https://github.com/apache/flink-cdc) | ASF (part of Flink) | MySQL, Postgres, Oracle, MongoDB… | CDC sources for Flink: full snapshot + incremental reads with no lock, plus YAML pipelines straight into Paimon, Doris, StarRocks… | CDC into a lakehouse/OLAP database with transformations, no Kafka required |
| [Airbyte CDC](https://docs.airbyte.com/understanding-airbyte/cdc) | Airbyte Inc. | Postgres, MySQL, SQL Server | CDC mode inside Airbyte (uses Debezium under the hood) | You already run Airbyte |

**How CDC works:** the tool reads the database's transaction log (MySQL binlog, Postgres WAL, Oracle redo/LogMiner) instead of querying tables. That means low overhead on the source and no missed deletes, and every insert, update, and delete is captured in commit order.

## Streaming Platforms → [03-Data-Streaming](../03-Data-Streaming/)

| Project | Backed by | What it does |
|---|---|---|
| [Apache Kafka](https://kafka.apache.org) | ASF | Distributed commit log; the backbone of most streaming stacks (newer versions run in KRaft mode with no ZooKeeper) |
| [Apache Pulsar](https://pulsar.apache.org) | ASF | Messaging + streaming with storage separated from compute (BookKeeper), multi-tenant, geo-replication |
| [Apache RocketMQ](https://rocketmq.apache.org) | ASF | Messaging and streaming platform with transactional messages |

## Orchestration → [05-Orchestration](../05-Orchestration/)

| Project | Backed by | What it does | Use when |
|---|---|---|---|
| [Apache Airflow](https://airflow.apache.org) | ASF | Python-defined DAGs of tasks with scheduling, retries, a huge provider ecosystem, and a UI | The industry default; most job postings ask for it |
| [Dagster](https://dagster.io) | Dagster Labs | Asset-based orchestration with built-in lineage, typing, and testability | You think in data assets rather than tasks |
| [Prefect](https://www.prefect.io) | Prefect Technologies | Pythonic workflows with dynamic flows | Lightweight, code-first orchestration |
| [Apache DolphinScheduler](https://dolphinscheduler.apache.org) | ASF | Visual drag-and-drop DAG scheduler | You want low-code scheduling |

## Transformation → [06-Transformation](../06-Transformation/)

| Project | Backed by | What it does | Use when |
|---|---|---|---|
| [dbt Core](https://github.com/dbt-labs/dbt-core) | dbt Labs | SQL + Jinja models with refs/DAG, tests, docs, snapshots (SCD2), incremental models | Transformations inside the warehouse/lakehouse (the "T" in ELT) |
| [SQLMesh](https://sqlmesh.com) | Tobiko Data | dbt alternative with virtual environments, column-level lineage, and plan/apply | You want safer deploys and cheaper dev environments |

## Data Quality → [08-Data-Quality](../08-Data-Quality/)

| Project | Backed by | What it does |
|---|---|---|
| [Great Expectations](https://greatexpectations.io) | GX | Declarative "expectations" (tests) on data, with generated data docs |
| [Soda Core](https://github.com/sodadata/soda-core) | Soda | YAML-based (SodaCL) data quality checks |
| [Deequ](https://github.com/awslabs/deequ) | AWS Labs | Unit tests for data on Spark (PyDeequ for Python) |
| dbt tests | dbt Labs | `unique`, `not_null`, `relationships`, `accepted_values`, plus custom tests |

## Catalogs, Metadata & Governance

| Project | Backed by | What it does |
|---|---|---|
| [Hive Metastore](https://hive.apache.org) | ASF | Classic table catalog that Spark, Trino, and others still use |
| [Apache Polaris](https://polaris.apache.org) | ASF (incubating) | Iceberg REST catalog |
| [Project Nessie](https://projectnessie.org) | Dremio | Git-like branching and commits for Iceberg catalogs |
| [Unity Catalog OSS](https://www.unitycatalog.io) | LF AI & Data | Open-source catalog for tables, AI assets, and governance |
| [Apache Gravitino](https://gravitino.apache.org) | ASF | Federated metadata lake across catalogs |
| [DataHub](https://datahubproject.io) / [OpenMetadata](https://open-metadata.org) | Acryl / Collate | Data discovery, lineage, and ownership |
| [Apache Atlas](https://atlas.apache.org) | ASF | Governance and lineage for the Hadoop ecosystem |

## Storage & File Formats

| Project | Backed by | What it does |
|---|---|---|
| [Apache Parquet](https://parquet.apache.org) | ASF | Columnar file format, the default for analytics |
| [Apache ORC](https://orc.apache.org) | ASF | Columnar file format, common with Hive |
| [Apache Avro](https://avro.apache.org) | ASF | Row-based format with schema evolution; common for Kafka messages |
| [Apache Arrow](https://arrow.apache.org) | ASF | In-memory columnar format for zero-copy data exchange between tools |
| [Apache Hadoop HDFS](https://hadoop.apache.org) / [Apache Ozone](https://ozone.apache.org) | ASF | Distributed file system / object store |
| [MinIO](https://min.io) | MinIO Inc. (AGPL) | S3-compatible object storage for local and on-prem lakehouses |

## Visualization

| Project | Backed by | What it does |
|---|---|---|
| [Apache Superset](https://superset.apache.org) | ASF | BI and dashboarding, with SQL Lab |
| [Metabase](https://www.metabase.com) | Metabase Inc. | Simple BI for non-technical users |

## A Typical Open-Source Lakehouse Stack

```
OLTP DB (MySQL/Postgres)
   │  Debezium / Maxwell / Flink CDC
   ▼
Kafka ──► Flink / Spark / SeaTunnel ──► Iceberg on S3/MinIO (catalog: Polaris / Nessie / Hive Metastore)
                                              │
                                     dbt (on Trino/Spark) transforms
                                              │
                                     Trino / StarRocks ──► Superset
Orchestrated by Airflow/Dagster · Quality checks by Great Expectations/Soda
```
