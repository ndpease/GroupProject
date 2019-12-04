CREATE TABLE EMPLOYEE (
	EmployeeID			Numeric(10) PRIMARY KEY not null,
	UserName			CHAR(20),
	Password 			CHAR(20),
	EmployeeName		CHAR(30)
);


CREATE TABLE GUEST (
	GuestID				Numeric(10) PRIMARY KEY not null,
	UserName			CHAR(20),
	Password			CHAR(20),
	GuestName			CHAR(30),
);


CREATE TABLE BOOKING (
	BookingID					Numeric(10) PRIMARY KEY not null,
	BookedRoom			Numeric(10)
		REFERENCES ROOM(RoomID) not null,
	BookingGuest		Numeric(10)
		REFERENCES GUEST(GuestID) not null,
	BookingEmployee		Numeric(10)
		REFERENCES EMPLOYEE(EmployeeID),
	CheckInYear			Numeric(5),
	CheckInDay			Numeric(5),
	CheckOutYear		Numeric(5),
	CheckOutDate		Numeric(5)
);


CREATE TABLE ROOM (
	RoomID				Numeric(10) PRIMARY KEY not null,
	RoomBookQuantity	Numeric(5),
	RoomBooked			CHAR(10) CHECK(RoomBooked in ('0', '1')),
	BedOption			Numeric(2),
	KitchenOption		Numeric(2),
	CoffeeOption		Numeric(2),
	AccessibleOption	Numeric(2),
	RoomNumber			Numeric(5),
	RoomCostPerNight	Numeric(5,2),
	RoomStatus			CHAR(10) CHECK (RoomStatus in ('0', '1'))
);


CREATE TABLE VALUE_GUEST (
	ValueClubID			Numeric(10) PRIMARY KEY not null,
	NumberOfBookings	Numeric(10),
	TotalAmountSpent	FLOAT(20),
	GuestID				Numeric(10)
		REFERENCES GUEST(GuestID),
	UserName			CHAR(20),
	Password			CHAR(20)
);
	








