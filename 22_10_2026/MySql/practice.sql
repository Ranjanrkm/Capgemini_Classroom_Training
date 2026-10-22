CREATE DATABASE IF NOT EXISTS student_training;

USE student_training;

CREATE TABLE students (
    sl_no INT,
    batch_no VARCHAR(20),
    uid VARCHAR(20),
    email_address VARCHAR(255),
    full_name VARCHAR(255),
    mobile_for_calls VARCHAR(15),
    mobile_for_whatsapp VARCHAR(15),
    parent_phone VARCHAR(15),
    parent_name VARCHAR(255),
    gender VARCHAR(10),
    dob VARCHAR(15),
    course_type VARCHAR(100),
    stream VARCHAR(100),
    year_of_passing INT,
    college_name VARCHAR(255),
    training_status VARCHAR(50),
    superset_id VARCHAR(20)
);

INSERT INTO students (sl_no, batch_no, uid, email_address, full_name, mobile_for_calls, mobile_for_whatsapp, parent_phone, parent_name, gender, dob, course_type, stream, year_of_passing, college_name, training_status, superset_id) VALUES
(1, 'T1402005', 'T140200522', 'sayyedaltamashali4807@gmail.com', 'Sayyed Altamash Mukhtar Ali', '9004739447', '9004739447', '9004513904', 'Shabnam Bano', 'Male', '01/03/2005', 'BE / BTech (directly)', 'Electronics and computer science', 2026, 'Rizvi college of engineering', 'Under Training', '7586165'),
(2, 'T1414001', 'T141400101', 'shreyagujar379@gmail.com', 'Shreya Santosh Gujar', '9370193125', '9370193125', '9730357266', 'Hemlata Santosh Gujar', 'Female', '01/08/2004', 'BE / BTech (directly)', 'Electronics and Telecommunication Engineering', 2026, 'Pune Vidyarthi Grihas College of Engineering and Shrikrushna S Dhamankar Institute of Management Nashik', 'Under Training', '8121008'),
(3, 'T1414001', 'T141400102', 'preranathok@gmail.com', 'Prerana Ramesh Thok', '7038968219', '7038968219', '9579480093', 'Kalpana Ramesh Thok', 'Female', '19/02/2005', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '8123573'),
(4, 'T1414001', 'T141400125', 'sharvanijadhav2005@gmail.com', 'Jadhav Shravani Dnyaneshwar', '8010324475', '8010324475', '9822056053', 'Dnyaneshwar Jadhav', 'Female', '02/07/2005', 'BE / BTech (directly)', 'Information Technology and Engineering (IT)', 2026, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '8124461'),
(5, 'T0502013', 'T050201305', 'ankitasonawane1209@gmail.com', 'Ankita Rajesh Sonawane', '7720880212', '7720880212', '9764542720', 'Rajesh U. Sonawane', 'Female', '09/02/2003', 'BE / BTech (after diploma)', 'Computer Science and Technology', 2025, 'Usha Mittal Institute of Technology, SNDT Women''s University', 'Under Training', '5643969'),
(6, 'T0504007', 'T050400712', 'hirayjaaee@gmail.com', 'Jaaee Bhausaheb Hiray', '8625845257', '8625845257', '9307070324', 'Unnati Hiray', 'Female', '16/06/2003', 'BE / BTech (directly)', 'Computer Engineering', 2025, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '5848387'),
(7, 'T0302002', 'T030200222', 'shrutikabadi9@gmail.com', 'Shruti Vijay Kabadi', '7666624821', '7666624821', '9272627810', 'Vijay Kabadi', 'Female', '12/02/2003', 'BE / BTech (after diploma)', 'Computer Science and Engineering (CSE)', 2025, 'Shivajirao S. Jondhle College Of Engineering & Technology - SSJCET', 'Under Training', '7049141'),
(8, 'T1402005', 'T140200501', 'afzalchaudhari143@gmail.com', 'Mohd Afzal Mohd Akbar Chaudhary', '8850018727', '8850018727', '8850018727', 'Mohd Akbar Chaudhary', 'Male', '04/08/2003', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Rizvi college of engineering', 'Under Training', '7448593'),
(9, 'T1202001', 'T120200130', 'pawarduru1031@gmail.com', 'Durvesh Uttam Pawar', '9833879932', '9833879932', '8691945350', 'Ulka Uttam Pawar', 'Male', '11/10/2004', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Watumull Institute Of Engineering And Technology', 'Under Training', '8124568'),
(10, 'T1402005', 'T140200506', 'himanshujaiswar16@gmail.com', 'Himanshu Asharam Jaiswar', '7977523821', '7977523821', '8108315991', 'Samundra Devi Asharam Jaiswar', 'Male', '28/09/2002', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2025, 'Vasantdada Patil Pratishthan''s College of Engineering and Visual Arts', 'Under Training', '6505856'),
(11, 'T1402005', 'T140200531', 'purva924@gmail.com', 'Purva Pradip Patil', '8767747538', '8767747538', '8788340075', 'Brother', 'Female', '03/10/2003', 'BE / BTech (directly)', 'Electronics and Communications Engineering (ECE)', 2025, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '5847932'),
(12, 'T1414001', 'T141400120', 'srishtibhagat2003@gmail.com', 'Srishti Suhas Bhagat', '9833837833', '9833837833', '9768234397', 'Shreya Bhagat', 'Female', '14/08/2003', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2025, 'Shivajirao S. Jondhle College of Engineering & Technology,Shahapur, Asangaon,', 'Under Training', '6744641'),
(13, 'T1414001', 'T141400104', 'bhumikamble714@gmail.com', 'BHUMI SUBHASH KAMBLE', '7387899705', '7387899705', '8237539024', 'Sunita Subhash Kamble', 'Female', '22/11/2004', 'BE / BTech (directly)', 'Information Technology and Engineering (IT)', 2026, 'Vidyavardhini''s College of Engineering And Technology', 'Under Training', '8107843'),
(14, 'T0302002', 'T030200219', 'wadkarprachi05@gmail.com', 'prachi prakash wadkar', '9324362776', '9324362776', '9869550043', 'Prakash', 'Female', '05/07/2004', 'BE / BTech (after diploma)', 'Computer Science and Engineering (CSE)', 2025, 'Shivajirao S. Jondhle College Of Engineering & Technology - SSJCET', 'Under Training', '5849445'),
(15, 'T1402005', 'T140200515', 'bhagwatom503@gmail.com', 'Om Sunil Bhagwat', '7499826739', '9607606803', '7558646291', 'Pratibha Sunil Bhagwat', 'Male', '09/11/2003', 'BE / BTech (after diploma)', 'Artificial Intelligence and Machine learning Engineering (AIML)', 2025, 'Shivajirao S Jondhale College of Engineering Dombivili, Thane', 'Under Training', '8106675'),
(16, 'T1402005', 'T140200526', 'shrushtiboraste@gmail.com', 'Srushti Bhausaheb Boraste', '7083879077', '7083879077', '9765594172', 'Bhausaheb Punjaji Boraste', 'Female', '24/05/2004', 'BE / BTech (directly)', 'Artificial Intelligence and Data Science (AI & DS)', 2026, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '7100833'),
(17, 'T1414001', 'T141400105', 'janhavimusale43@gmail.com', 'Janhavi Sanjivkumar Musale', '8208764367', '8208764367', '9527725915', 'Sanjivkumar Babulal Musale', 'Female', '12/08/2003', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2025, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '6106253'),
(18, 'T1402002', 'T140200220', 'varungolhe51@gmail.com', 'Varun Pundalik Golhe', '8888452698', '8888452698', '8779600775', 'Vaibhavi Golhe', 'Male', '07/04/2005', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Yadavrao Tasgaonkar Institute of Engineering & Technology', 'Under Training', '8104792'),
(19, 'T1402002', 'T140200205', 'omkargawade1015@gmail.com', 'Omkar Ashok Gawade', '7977097048', '7977097048', '9029130066', 'Ashok Tanu Gawade', 'Male', '25/12/2005', 'BE / BTech (after diploma)', 'Computer Science and Engineering (CSE)', 2026, 'Yadavrao Tasgaonkar Institute of Engineering & Technology', 'Under Training', '8125023'),
(20, 'T1202001', 'T120200166', 'tanvibhave4@gmail.com', 'Tanvi Sanjay Bhave', '8693875572', '8693875572', '9819232578', 'Shalini Sanjay Bhave', 'Female', '08/11/2004', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Watumull Institute Of Engineering And Technology', 'Under Training', '8124118'),
(21, 'T1414001', 'T141400112', 'pratikgodasecse07@gmail.com', 'Pratik Satish Godase', '8888101209', '8888101209', '9890529696', 'Satish Godase', 'Male', '09/05/2002', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2025, 'SVERI''s College of Engineering, Pandharpur', 'Under Training', '6321424'),
(22, 'T0504007', 'T050400722', 'mayuridashpute9881@gmail.com', 'Mayuri Mahendra Dashpute', '9307820189', '9307820189', '9373706657', 'Sangita', 'Female', '17/03/2003', 'BE / BTech (directly)', ' Information Technology', 2025, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '5843883'),
(23, 'T0302002', 'T030200241', 'kaushikpatil5271@gmail.com', 'KAUSHIK SUDHIR PATIL', '9545721032', '9545721032', '9373998479', 'Sudhir Rodu Patil', 'Male', '07/04/2005', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2025, 'Shivajirao S. Jondhle College Of Engineering & Technology - SSJCET', 'Under Training', '7353732'),
(24, 'T1414001', 'T141400199', 'yashpotdukhe25@gmail.com', 'Yash Suresh Potdukhe', '9604623062', '9604623062', '9356301076', 'Ruchita', 'Male', '25/11/2003', 'BE / BTech (directly)', 'Artificial Intelligence and Data Science (AI & DS)', 2026, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '7473223'),
(25, 'T1414001', 'T141400103', 'gadgeatharva6@gmail.com', 'ATHARVA Santosh Gadge', '9594835518', '9594835518', '9594835518', 'ATHARVA', 'Male', '26/09/2004', 'BE / BTech (after diploma)', 'Computer Science and Engineering (CSE)', 2026, 'Yadavrao Tasgaonkar College of Engineering and Management', 'Under Training', '8124993'),
(26, 'T1414001', 'T141400109', 'ajayparbhane4@gmail.com', 'Ajay Arjun Parbhane', '7499682377', '7499483619', '7499682377', 'Arjun Parbhane', 'Male', '19/08/2004', 'BE / BTech (directly)', 'Artificial Intelligence and Data Science (AI & DS)', 2026, 'Vidya Pratishthan''s Kamalnayan Bajaj Institute of Engineering and Technology, Baramati', 'Under Training', '5967313'),
(27, 'T1414001', 'T141400117', 'himanshupardhi792@gmail.com', 'Himanshu Chhaganlal Pardhi', '9325644913', '9325644913', '9834577067', 'Mrunali Pardhi', 'Male', '24/02/2002', 'BE / BTech (after diploma)', 'Artificial Intelligence and Machine learning Engineering (AIML)', 2025, 'G H Raisoni College of Engineering, Nagpur', 'Under Training', '2968354'),
(28, 'T1414001', 'T141400198', 'utkarsh6918@gmail.com', 'Utkarsh Tripathi', '9729554101', '9729554101', '9418988186', 'Anil Kumar Tripathi', 'Male', '16/10/2003', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Chandigarh University', 'Under Training', '6982777'),
(29, 'T1414001', 'T141400121', 'pjesu.2003@gmail.com', 'Pooja Prakash Jesu', '9370609203', '9370609203', '7020611149', 'Mohini Jesu', 'Female', '01/09/2003', 'BE / BTech (after diploma)', 'Computer Science and Engineering (CSE)', 2026, 'Cummins College of Engineering for Women', 'Under Training', '7083129'),
(30, 'T1414001', 'T141400115', 'bandaruyaswanth7@gmail.com', 'Bandaru Yaswanth', '9398106078', '9398106078', '8978275293', 'Bandaru Mulayya', 'Male', '18/07/2004', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Baba Institute of Technology and Sciences', 'Under Training', '7459307'),
(31, 'T1414001', 'T141400122', 'pranulondhe381@gmail.com', 'Pranali Babasaheb Londhe', '8767135572', '8767135572', '9503954340', 'Hirabai Babasaheb Londhe', 'Female', '29/09/2004', 'BE / BTech (after diploma)', 'Artificial Intelligence and Machine learning Engineering (AIML)', 2026, 'Sahyadri Valley College of Engineering and Technology Rajuri Pune', 'Under Training', '4296866'),
(32, 'T1414001', 'T141400106', 'rabindonmes710@gmail.com', 'Mohamed Rabin', '7034966054', '7034966054', '9846604267', 'Basheer Kp', 'Male', '04/10/2002', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2025, 'Excel Engineering College Namakkal Tamil Nadu', 'Under Training', '5289971'),
(33, 'T1414001', 'T141400111', 'rajankit2118@gmail.com', 'Ankit Raj', '7564881255', '7564881255', '9934730752', 'Umesh Kumar Verma', 'Male', '20/08/2002', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2025, 'Galgotias University', 'Under Training', '5011947'),
(34, 'T1414001', 'T141400116', 'aravindgaje2@gmail.com', 'Gaje Aravind', '9346852655', '9346852655', '9703852655', 'Ayodya', 'Male', '02/05/2002', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2025, 'Sr university', 'Under Training', '5522552'),
(35, 'T1414001', 'T141400118', 'potdarsonali2003@gmail.com', 'Sonali Sanjay Potdar', '8625000679', '8625000679', '9822020679', 'Sanjay Potdar', 'Female', '21/08/2003', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Sinhgad Academy of Engineering, Kondhwa (SAE, Kondhwa)', 'Under Training', '8233678'),
(36, 'T1414001', 'T141400119', 'ujjvalpateliya@gmail.com', 'Ujjval pateliya', '8435423244', '8435423244', '9407356356', 'Mahesh Pateliya', 'Male', '17/01/2005', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Sagar Institute of Science Technology And Engineering Bhopal', 'Under Training', '4937462'),
(37, 'T1414001', 'T141400114', 'harshadarane.3083@gmail.com', 'Harshada Santosh Rane', '9370601067', '9370601067', '9503999840', 'Santosh Rane', 'Female', '30/08/2003', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2025, 'Loknete Gopinathji Munde Institute of Engineering Education & Research', 'Under Training', '6359812'),
(38, 'T1414001', 'T141400108', 'sahilrajmfp2004@gmail.com', 'Sahil Kumar', '8002049027', '8002049027', '9852106646', 'Suresh Mahto', 'Male', '24/08/2005', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'CV Raman Global University', 'Under Training', '7286150'),
(39, 'T1414001', 'T141400123', 'kavyavankayalapati391@gmail.com', 'VANKAYALAPATI KAVYA', '8919951981', '8919951981', '9652738424', 'Vankayalapati Ravikumar', 'Female', '22/08/2003', 'BE / BTech (directly)', 'Information Technology and Engineering (IT)', 2026, 'DVR & Dr. HS MIC College of Technology', 'Under Training', '5787570'),
(40, 'T1414001', 'T141400107', 'aravinthanbdev@gmail.com', 'Aravinthan B', '9952155110', '9952155110', '8903878730', 'Balasubramaniyan A', 'Male', '18/10/2005', 'BE / BTech (directly)', 'Computer Science and Engineering (CSE)', 2026, 'Easa College of engineering and technology', 'Under Training', '7337508'),
(41, 'T1414001', 'T141400113', 'adarsh4425282@gmail.com', 'Adarsh A', '9633768806', '9633768806', '9446938806', 'Anandan V', 'Male', '03/08/2003', 'BE / BTech (after diploma)', 'Computer Science and Engineering (CSE)', 2025, 'College of engineering kottarakkara kollam kerala', 'Under Training', '5926376'),
(42, 'T1414001', 'T141400110', 'vaibhav.abstractwork@gmail.com', 'Vaibhav Shivaji Shewale', '8767246791', '8767246791', '7558746138', 'Shivaji Shewale', 'Male', '17/07/2004', 'BE / BTech (directly)', 'Artificial Intelligence and Data Science (AI & DS)', 2026, 'Ajeenkya DY Patil University', 'Under Training', '7290397'),
(43, 'T0502011', 'T050201118', 'pranaybhatkar81@gmail.com', 'Pranay Santosh Bhatkar', '8669727126', '8669727126', '9921709669', 'Santosh Pandurang Bhatkar', 'Male', '02/05/2003', 'BE / BTech (directly)', ' Information Technology.', 2025, 'Padmabhooshan Vasantraodada Patil Institute of Technology', 'Under Training', '6182760'),
(44, 'T0504007', 'T050400731', 'rutujashinde0503@gmail.com', 'Rutuja Dhanaji Shinde', '7499647956', '7499647956', '9011945491', 'Dhanaji Baburao Shinde', 'Female', '05/07/2003', 'BE / BTech (directly)', 'Artificial Intelligence and Data Science', 2025, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '5676892'),
(45, 'T1414001', 'T141400124', 'lokhandetanisha2005@gmail.com', 'TANISHA AJAY LOKHANDE', '8691838091', '8691838091', '8999113025', 'Prabha ajay Lokhande', 'Female', '02/03/2005', 'BE / BTech (directly)', 'Information Technology and Engineering (IT)', 2026, 'Pune Vidyarthi Griha''s College of Engineering, Nashik', 'Under Training', '8122642'),
(46, 'T0302003', 'T030200345', 'vu4f2223070@pvppcoe.ac.in', 'Diksha Uday Prabhu', '8425026064', '8425026064', '9969056064', 'Anuja Uday Prabhu', 'Female', '31/03/2004', 'BE / BTech (directly)', 'Information Technology and Engineering (IT)', 2026, 'Vasantdada Patil Pratishthan''s College of Engineering and Visual Arts', 'Under Training', '7135056');

SELECT * FROM students;

SELECT COUNT(*) AS male_count
FROM students
WHERE gender = 'Male';

SELECT COUNT(*) AS female_count
FROM students
WHERE gender = 'Female';

SELECT gender, COUNT(*) AS total_students
FROM students
GROUP BY gender;

