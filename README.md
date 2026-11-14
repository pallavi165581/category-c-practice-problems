# Category C — Practice Problems (Java)

Week 12 S12 DSA practice set. Six self-contained Java programs, one per problem. Each
`main` runs the sample data from the problem statement and prints the expected output.

## Problems

| # | Problem | Concepts | File |
|---|---------|----------|------|
| 1 | Campus Staff Salary | Inheritance, method overriding, polymorphic array | `src/Problem01_CampusStaffSalary.java` |
| 2 | Class Report Card | Encapsulation, setter validation, early-stopping bubble sort | `src/Problem02_ClassReportCard.java` |
| 3 | Library Return Desk | Stack on fixed array, circular queue on fixed array | `src/Problem03_LibraryReturnDesk.java` |
| 4 | Payment Processing | Interface, polymorphism, fee calculation | `src/Problem04_PaymentProcessing.java` |
| 5 | Weekly Rainfall Analysis | Single-pass array scan, max-index tracking | `src/Problem05_WeeklyRainfallAnalysis.java` |
| 6 | Hostel Electricity Bill | Slab pricing with else-if ladder, input validation | `src/Problem06_HostelElectricityBill.java` |

## Run

```bash
javac -d out src/*.java
java -cp out Problem01_CampusStaffSalary
java -cp out Problem02_ClassReportCard
java -cp out Problem03_LibraryReturnDesk
java -cp out Problem04_PaymentProcessing
java -cp out Problem05_WeeklyRainfallAnalysis
java -cp out Problem06_HostelElectricityBill
```

## Complexity

- **P1** — printing all salaries: O(n)
- **P2** — bubble sort: O(n) best (already sorted, early stop), O(n²) worst
- **P3** — every stack/queue operation: O(1)
- **P4** — processing all payments: O(n)
- **P5** — O(n) time, O(1) extra space
- **P6** — billing all rooms: O(n)

## Sample outputs

**P1** — `Grand Total Salary: 142000.0`
**P2** — Neha skipped; ranked Pooja → Asha → Ravi → Kiran; `Sorted in 3 passes`
**P3** — B4 rejected (pile full); `pile is empty`, `no one waiting` messages
**P4** — Card fees 40.0/60.0; `Total Amount Processed: 7600.0`
**P5** — `Average Rainfall: 14.29 mm`, `Wettest Day: Day 6`, `Total Dry Days: 2`
**P6** — B202 invalid; `Rooms billed 4, total 3070`
