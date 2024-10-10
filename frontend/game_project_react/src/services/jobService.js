// Connects and fetchs data from backend api.

export const getJobs = async () => {
  try {
    const response = await fetch("http://localhost:8080/api/jobs");

    // Check if the response is ok.
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const data = await response.json();
    return data;
  } catch (error) {
    console.error("Error fetching jobs:", error);
  }
};
