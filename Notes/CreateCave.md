public void createCave (Cave cave) {

    try (Connection conn = ConnectionUtil.getConnection()) {
    String caveQuery = "INSERT INTO CAVE(CAVE_ID, CAVE_NAME, MAX_BEARS)
                        VALUES(" + cave.getId() + "," + cave.getName() + "," + cave.getMaxBear()";
    PreparedStatement ps = conn.prepareStatement(caveQuery);
    ps.executeUpdate();
    }
    catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}

}

string s = "hello" + asasdasdasd + "world";