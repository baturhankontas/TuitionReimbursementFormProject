Feature: TuitionPro login link works

Scenario: TuitionPro Login works for Julio Sanchez
	Given Julio Sanchez is on the TuitionPro Home Page
	When The guest enter "Julio"  in the name field
	And The guest enter "Sanchez" in the surname field
	And The guest press the "Let me in." button
	Then The guest should be on the Main Page

	Scenario: TuitionPro Login works for Dan OBrien
	Given The guest is on the TuitionPro Home Page
	When The guest enter "Dan"  in the name field
	And The guest enter "OBrien" in the surname field
	And The guest press the "Let me in." button
	Then The guest should be on the Main Page