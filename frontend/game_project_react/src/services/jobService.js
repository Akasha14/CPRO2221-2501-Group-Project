export const getJobs = async () => {
  try {
    const response = await fetch("http://localhost:8080/api/jobs");

    // Check if the response is ok (status code 200-299)
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const data = await response.json();
    return data;
  } catch (error) {
    console.error("Error fetching jobs:", error);
    throw error; // Re-throw the error if needed for further handling
  }
};
