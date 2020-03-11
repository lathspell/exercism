package clock

import "fmt"

// Clock represents a clock with just hours and minutes
type Clock struct {
	hours   int
	minutes int
}

// New creates an instance of type Clock
func New(hours, minutes int) Clock {
	return Clock{}.addBoth(hours, minutes)
}

func (c Clock) String() string {
	return fmt.Sprintf("%02d:%02d", c.hours, c.minutes)
}

// Add some minutes
func (c Clock) Add(minutes int) Clock {
	return c.addBoth(0, minutes)
}

// Subtract some minutes
func (c Clock) Subtract(minutes int) Clock {
	return c.addBoth(0, -minutes)
}

func (c Clock) addBoth(hours, minutes int) Clock {
    overflowHours := 0

    c.minutes += minutes
    for c.minutes >= 60 {
        c.minutes -= 60
        overflowHours++
    }
	for c.minutes < 0 {
		c.minutes += 60
		overflowHours--
	}

    c.hours += hours
    c.hours += overflowHours
    for c.hours >= 24 {
        c.hours -= 24
    }
    for c.hours < 0 {
		c.hours += 24
	}

	return c
}
